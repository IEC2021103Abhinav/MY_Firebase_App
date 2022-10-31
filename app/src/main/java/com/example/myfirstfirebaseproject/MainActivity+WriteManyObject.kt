package com.example.myfirstfirebaseproject

fun MainActivity.writemanyobj()
{
//    we need to many many items that is an array of items
    val myItems= arrayOf(Item("Vishwa","Lucknow"),
                                Item("John","America"))
    val  myUid:String=MainActivity.auth.currentUser!!.uid
    for(each:Item in myItems)
    {
        var itemMap= mapOf("name" to each.name,"city" to each.city)
        val childUpdate=HashMap<String,Any>()
        childUpdate["/$myUid/items/${each.name}"]=itemMap
//        it basically says go to reference and then find MyUid then add items in that and then add the name
        MainActivity.database.reference.updateChildren(childUpdate)

    }

}