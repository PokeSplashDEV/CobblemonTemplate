package org.pokesplash.cobblemontemplate.util;

import net.impactdev.impactor.api.economy.EconomyService;
import net.impactdev.impactor.api.economy.accounts.Account;
import net.impactdev.impactor.api.economy.currency.Currency;
import net.impactdev.impactor.api.economy.transactions.EconomyTransaction;
import net.impactdev.impactor.api.economy.transactions.EconomyTransferTransaction;
import net.kyori.adventure.key.Key;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Class to interact with Impactor economy module.
 */
public class ImpactorService {

	// Economy service.
	private EconomyService service;
	// Currency to use.
	private Currency currency;

	/**
	 * Constructor to create the Impactor service with the given currency.
	 * @param currencyKey the key of the currency to use, pass null if you want the default.
	 */
	public ImpactorService(Key currencyKey) {
		service = EconomyService.instance();

		// If no currency is given, use the default from Impactor.
		currency = currencyKey == null ? service.currencies().primary() :
				service.currencies().currency(currencyKey).orElse(service.currencies().primary());
	}

	/**
	 * Method to get a users account for the currency stored.
	 * @param uuid the uuid of the player
	 * @return The account of the player.
	 */
	public Account getAccount(UUID uuid) {
		if (!service.hasAccount(uuid).join()) {
			return null;
		}
		return service.account(currency, uuid).join();
	}

	/**
	 * Method to add a value to a users account.
	 * @param account The account to add the value to
	 * @param amount The amount to add to the account
	 * @return true if successful.
	 */
	public boolean add(Account account, double amount) {
		EconomyTransaction transaction = account.depositAsync(new BigDecimal(amount)).join();

		return transaction.successful();
	}

	/**
	 * Method to remove value from an account
	 * @param account The account to remove from
	 * @param amount The amount to remove
	 * @return true if the removal was successful.
	 */
	public boolean remove(Account account, double amount) {
		EconomyTransaction transaction = account.withdrawAsync(new BigDecimal(amount)).join();

		return transaction.successful();
	}

	/**
	 * Transfer money from one account to another
	 * @param sender The player to send money from
	 * @param receiver The player to receive the money
	 * @param amount The amount to transfer
	 * @return True if transfer was successful.
	 */
	public boolean transfer(Account sender, Account receiver, double amount) {
		EconomyTransferTransaction transaction = sender.transferAsync(receiver, new BigDecimal(amount)).join();

		return transaction.successful();
	}
}
