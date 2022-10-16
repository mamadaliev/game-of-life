package mamadaliev.view;

public interface View<T> {

    void init(T data);

    void render(T data);
}
