class ContaBancaria {
        private double accountNumber;
        private double ballance;
        public String accountHolder;

        public void setAccountNumber(double accountNumber) {
                this.accountNumber = accountNumber;
        }

        public void setBallance(double ballance) {
                this.ballance = ballance;
        }

        public void setAccountHolder(String accountHolder) {
                this.accountHolder = accountHolder;
        }

        public double getAccountNumber() {
                return accountNumber;
        }

        public double getBallance() {
                return ballance;
        }

        public String getAccountHolder() {
                return accountHolder;
        }
}


