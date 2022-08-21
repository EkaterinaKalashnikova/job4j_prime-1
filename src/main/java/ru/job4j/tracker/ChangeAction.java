package ru.job4j.tracker;

public class ChangeAction implements UserAction {
    private final Output out;

    public ChangeAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Edit item ===");
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name for Item: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Edit item is done.");
        } else {
            out.println(String.format("Item with id=%s not found.", id));
        }
        return true;
    }
}

