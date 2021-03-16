package eshopping.messages;

import java.util.List;

public class ResponseCart {
	
		private int totalitems;
		private int totalprice;
		
		private List<ResponseCartList> cart;

		public ResponseCart() {
		
		}

		public ResponseCart(int totalitems, int totalprice, List<ResponseCartList> cart) {
			super();
			this.totalitems = totalitems;
			this.totalprice = totalprice;
			this.cart = cart;
		}

		public int getTotalitems() {
			return totalitems;
		}

		public void setTotalitems(int totalitems) {
			this.totalitems = totalitems;
		}

		public int getTotalprice() {
			return totalprice;
		}

		public void setTotalprice(int totalprice) {
			this.totalprice = totalprice;
		}

		public List<ResponseCartList> getCart() {
			return cart;
		}

		public void setCart(List<ResponseCartList> cart) {
			this.cart = cart;
		}

		@Override
		public String toString() {
			return "ResponseCart [totalitems=" + totalitems + ", totalprice=" + totalprice + ", cart=" + cart + "]";
		}
		
		
}
