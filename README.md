<H1><b>Get started</b></h1>


1. You need to create an adapter
Kotlin:

```
private val adapter = MultiTypeAdapter()
```

Multi Type Adapter uses ListAdaper under the hood

2. You need to create an item

```
class TestItem(private val text: String) : MultiTypeViewBindingItem<ItemTestBinding, TestItem>() {

    override fun initializeViewBinding(view: View) = ItemTestBinding.bind(view)

    override val layoutId: Int
        get() = R.layout.item_test

    override fun bind(viewBinding: ItemTestBinding) {
        viewBinding.helloWorld.text = text
    }

    override fun areContentsTheSameObject(oldItem: TestItem?, newItem: TestItem?): Boolean {
        return oldItem?.text == newItem?.text
    }

    override fun areItemsTheSameObject(oldItem: TestItem?, newItem: TestItem?): Boolean {
        return oldItem?.text == newItem?.text
    }
    
}

```

3. Pass an array to the adapter

```
 val list = listOf(TestItem("example"))
 adapter.submitList(list)

```







