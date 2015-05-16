package string.symboltable;

public interface SymbolTable<Value> {
	
	public abstract void put(String key, Value v);
	public abstract boolean contains(String key);
	public abstract Value get(String key);
	public abstract void delete(String key);
	public abstract void printKeys();
	
}