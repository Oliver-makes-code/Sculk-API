# Sculk API
An API for interacting with sculk

## Usage

In your repositories block in `build.gradle`:
```groovy
repositories {
    //...
    maven { url "https://jitpack.io" }
}
```

In your dependencies block in `build.gradle`:
```groovy
dependencies {
    //...
    modImplementation("com.github.Oliver-makes-code:Sculk-API:-SNAPSHOT")
}
```

To make a block interactable, you need to implement the SculkInteractable interface:
```java
class BlockName extends Block implements SculkInteractable {
    //...

    @Override
    public int onInteract(BlockPos pos, WorldAccess world, int charge) {
        //Return the amount of charge you want to use from the sculk
        return 0;
    }
}
```
