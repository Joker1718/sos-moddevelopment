/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.table.GTableSorter;
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
/*     */ class null
/*     */   extends UIRoomModule
/*     */ {
/*     */   public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/*  86 */     GETTER<T> getter = new GETTER<T>()
/*     */       {
/*     */         
/*     */         public T get()
/*     */         {
/*  91 */           return (T)get.get();
/*     */         }
/*     */       };
/*     */     
/*  95 */     GGrid g = new GGrid(section, 2, y1);
/*  96 */     UIRoomModule.UIRoomModuleImp.this.appendPanel(section, g, getter, x1, y1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendManageScr(GGrid icons, GGrid text, GuiSection extra) {
/* 101 */     UIRoomModule.UIRoomModuleImp.this.appendMain(icons, text, extra);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {
/* 107 */     UIRoomModule.UIRoomModuleImp.this.appendTableFilters(filters, sorts, appliers);
/*     */   }
/*     */   
/*     */   public void appendButt(GuiSection s, GETTER<RoomInstance> get) {
/* 111 */     UIRoomModule.UIRoomModuleImp.this.appendTableButt(s, get);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox box, Room room, int rx, int ry) {
/* 117 */     UIRoomModule.UIRoomModuleImp.this.hover(box, room);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room room, int rx, int ry) {
/* 123 */     UIRoomModule.UIRoomModuleImp.this.problem(room, free, errors, warnings);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIRoomModule$UIRoomModuleImp$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */