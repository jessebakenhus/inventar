package us.bakenh.inventar.domain.model;

public class ConfigModel {

    private DatabaseConfig database;

    public DatabaseConfig getDatabase() {
        return database;
    }

    public void setDatabase(DatabaseConfig database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "ConfigModel{" +
                "database=" + database +
                '}';
    }

    public static class DatabaseConfig {

        private String username;

        private String password;

        private String url;


        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public String getUrl() {
            return url;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "DatabaseConfig{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}
