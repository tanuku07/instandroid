package instagramlogin;

public interface OAuthAuthenticationListener {
        public abstract void onSuccess();

        public abstract void onFail(String error);
}
