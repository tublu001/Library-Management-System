package com.epam.user_interface;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.epam.exceptions.UserException;
import com.epam.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GroupMenu 
{
	private static final Logger LOGGER = LogManager.getLogger(GroupMenu.class);
	public GroupMenu() 
	{}
	
	
	@SuppressWarnings(value = {"all"})
	public static String showGroupUI(User user)
	{
		int flag = 0;
		String groupName = "Undefined";
		final Scanner input = new Scanner(System.in);
		
		while(flag==0)
		{
			LOGGER.info("1. Create a new group");
			LOGGER.info("2. Store in a existing group");
			LOGGER.info("0. Skip..(Ungrouped)\n\n\nChoose Any: ");
			char selection = 'Z';

				selection = input.next().charAt(0);

			
			AccountCrudGroup op = new GroupCrudOperations();
			try
			{
				switch (selection)
				{
					case '1':
						if (op.createGroup(user))
						{
							int lastItem = user.getGroups().size();
							groupName = user.getGroups().get(lastItem - 1);
							flag = 1;
						}
						break;
					case '2':
						groupName = op.storeInExistingGroup(user);
						flag = 1;
						break;
					case '0':
						flag = 1;
						break;
					default:
						break;
				}
			}
			catch (UserException e)
			{
				LOGGER.info(e.getMessage()+"\n\n");
			}
			catch (InputMismatchException e)
			{
				LOGGER.info("Invalid selection\n\n");
			}
		}
		return groupName;
	}

}