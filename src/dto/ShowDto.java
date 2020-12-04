package dto;

public class ShowDto {

		// 名称
		private static String soul_name;

		//非会員表示文字
		private static String payBeforeText;

		//会員表示文字
		private static String payAfterText;

		// 会員ユーザー判断フラグ
		private static String payFlg;

		public static String getSoul_name() {
			return soul_name;
		}

		public void setSoul_name(String soul_name) {
			ShowDto.soul_name = soul_name;
		}

		public static String getPayBeforeText() {
			return payBeforeText;
		}

		public void setPayBeforeText(String payBeforeText) {
			ShowDto.payBeforeText = payBeforeText;
		}

		public static String getPayAfterText() {
			return payAfterText;
		}

		public void setPayAfterText(String payAfterText) {
			ShowDto.payAfterText = payAfterText;
		}

		public static String getPayFlg() {
			return payFlg;
		}

		public void setPayFlg(String payFlg) {
			ShowDto.payFlg = payFlg;
		}

}