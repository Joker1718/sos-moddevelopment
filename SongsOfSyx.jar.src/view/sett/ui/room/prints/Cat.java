/*    */ package view.sett.ui.room.prints;
/*    */ 
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ class Cat
/*    */ {
/*    */   public boolean expanded = false;
/*    */   public int entries;
/*    */   public SPRITE icon;
/*    */   final Class<? extends RoomBlueprintImp> classs;
/* 13 */   public final ArrayListGrower<RoomBlueprintImp> prints = new ArrayListGrower();
/*    */   
/*    */   public Cat(RoomBlueprintImp blue) {
/* 16 */     this.icon = (SPRITE)blue.iconBig();
/* 17 */     this.classs = (Class)blue.getClass();
/* 18 */     this.prints.add(blue);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\prints\Cat.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */