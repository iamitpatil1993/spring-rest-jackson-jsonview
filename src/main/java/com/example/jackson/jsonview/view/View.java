package com.example.jackson.jsonview.view;

/**
 * This interface defines different Views for different models in application.
 * 
 * @author amipatil
 *
 */
public interface View {

	/**
	 * Enclosing type to define user views
	 * 
	 * @author amipatil
	 *
	 */
	public static interface UserView {

		/**
		 * View for external users
		 * 
		 * @author amipatil
		 *
		 */
		public static interface External {
		}

		/**
		 * View for internal services/uses
		 * 
		 * @author amipatil
		 *
		 */
		public static interface Internal extends External {
		}

		/**
		 * View to define desierilization of request body for POST call. any fields
		 * other than defined by this view, will be just ignored.
		 * 
		 * @author amipatil
		 *
		 */
		public static interface Post {
		}

		public static interface PUT {
		}
	}

}
