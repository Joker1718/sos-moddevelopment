/*     */ package settlement.room.main.category;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoomCategoryMain
/*     */ {
/*     */   public final CharSequence name;
/*     */   public final Icon icon;
/*     */   public final RoomCategorySub misc;
/*     */   public final LIST<RoomCategorySub> subs;
/*     */   private LIST<RoomBlueprintImp> all;
/*     */   
/*     */   RoomCategoryMain(CharSequence name, Icon icon, LIST<RoomCategorySub> subs) {
/* 108 */     this.name = name;
/* 109 */     this.icon = icon;
/* 110 */     this.subs = subs;
/* 111 */     this.misc = new RoomCategorySub(paramRoomCategories.all, RoomCategories.¤¤other, (SPRITES.icons()).m.questionmark, COLOR.WHITE100);
/* 112 */     this.misc.main = this;
/* 113 */     for (RoomCategorySub s : subs)
/* 114 */       s.main = this; 
/*     */   }
/*     */   
/*     */   private void n() {
/* 118 */     LinkedList<RoomBlueprintImp> all = new LinkedList();
/* 119 */     for (RoomCategorySub s : this.subs) {
/* 120 */       for (RoomBlueprintImp p : s.rooms())
/* 121 */         all.add(p); 
/*     */     } 
/* 123 */     for (RoomBlueprintImp p : this.misc.rooms())
/* 124 */       all.add(p); 
/* 125 */     this.all = (LIST<RoomBlueprintImp>)new ArrayList((Iterable)all);
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<RoomBlueprintImp> all() {
/* 130 */     if (this.all == null) {
/* 131 */       n();
/*     */     }
/* 133 */     return this.all;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\category\RoomCategories$RoomCategoryMain.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */