package org.cause4code.jackson.jsonview.view;

/**
 * This interface defines different Views for different models in application.
 * 
 * @author amipatil
 *
 */
public interface View {

	/**
	 * Enclosing type to define user views
	 */
	public static interface UserView {

		/**
		 * View for external users
		 */
		public static interface External {
		}

		/**
		 * View for internal services/uses
		 */
		public static interface Internal extends External {
		}

		/**
		 * View to define desierilization of request body for POST call. any fields
		 * other than defined by this view, will be just ignored.
		 */
		public static interface Post {
		}

		public static interface PUT {
		}
	}

}
