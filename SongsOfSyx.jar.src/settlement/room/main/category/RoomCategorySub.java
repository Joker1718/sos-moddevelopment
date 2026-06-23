/*    */ package settlement.room.main.category;
/*    */ 
/*    */ import init.sprite.UI.Icon;
/*    */ import settlement.room.main.RoomBlueprintImp;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ public final class RoomCategorySub
/*    */ {
/* 12 */   private final ArrayListGrower<RoomBlueprintImp> all = new ArrayListGrower();
/*    */   public final COLOR color;
/*    */   private final CharSequence name;
/*    */   private final Icon icon;
/*    */   RoomCategories.RoomCategoryMain main;
/*    */   
/*    */   RoomCategorySub(ArrayListGrower<RoomCategorySub> all, CharSequence name, Icon icon, COLOR color) {
/* 19 */     this.name = name;
/* 20 */     this.icon = icon;
/*    */     
/* 22 */     this.color = color;
/* 23 */     all.add(this);
/*    */   }
/*    */   
/*    */   public int add(RoomBlueprintImp imp) {
/* 27 */     return this.all.add(imp);
/*    */   }
/*    */   
/*    */   public CharSequence name() {
/* 31 */     return this.name;
/*    */   }
/*    */   
/*    */   public Icon icon() {
/* 35 */     return this.icon;
/*    */   }
/*    */   
/*    */   public LIST<RoomBlueprintImp> rooms() {
/* 39 */     return (LIST<RoomBlueprintImp>)this.all;
/*    */   }
/*    */   
/*    */   public RoomCategories.RoomCategoryMain main() {
/* 43 */     return this.main;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\category\RoomCategorySub.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */