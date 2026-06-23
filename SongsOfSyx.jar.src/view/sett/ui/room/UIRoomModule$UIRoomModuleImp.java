/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
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
/*     */ public class UIRoomModuleImp<T extends RoomInstance, B extends RoomBlueprintIns<T>>
/*     */ {
/*     */   protected final B blueprint;
/*     */   
/*     */   public UIRoomModuleImp(B blueprint) {
/*  52 */     this.blueprint = blueprint;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid g, GETTER<T> getter, int x1, int y1) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid icons, GGrid text, GuiSection sExtra) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendTableButt(GuiSection s, GETTER<RoomInstance> ins) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, T i) {}
/*     */ 
/*     */   
/*     */   protected void problem(T i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {}
/*     */ 
/*     */   
/*     */   public UIRoomModule make() {
/*  80 */     return new UIRoomModule()
/*     */       {
/*     */ 
/*     */         
/*     */         public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1)
/*     */         {
/*  86 */           GETTER<T> getter = new GETTER<T>()
/*     */             {
/*     */               
/*     */               public T get()
/*     */               {
/*  91 */                 return (T)get.get();
/*     */               }
/*     */             };
/*     */           
/*  95 */           GGrid g = new GGrid(section, 2, y1);
/*  96 */           UIRoomModule.UIRoomModuleImp.this.appendPanel(section, g, getter, x1, y1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void appendManageScr(GGrid icons, GGrid text, GuiSection extra) {
/* 101 */           UIRoomModule.UIRoomModuleImp.this.appendMain(icons, text, extra);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {
/* 107 */           UIRoomModule.UIRoomModuleImp.this.appendTableFilters(filters, sorts, appliers);
/*     */         }
/*     */         
/*     */         public void appendButt(GuiSection s, GETTER<RoomInstance> get) {
/* 111 */           UIRoomModule.UIRoomModuleImp.this.appendTableButt(s, get);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hover(GBox box, Room room, int rx, int ry) {
/* 117 */           UIRoomModule.UIRoomModuleImp.this.hover(box, room);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room room, int rx, int ry) {
/* 123 */           UIRoomModule.UIRoomModuleImp.this.problem(room, free, errors, warnings);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIRoomModule$UIRoomModuleImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */