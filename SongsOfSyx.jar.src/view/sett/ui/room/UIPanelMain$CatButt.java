/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.category.RoomCategories;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
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
/*     */ class CatButt
/*     */   extends GButt.BSection
/*     */ {
/*     */   int employees;
/*     */   int needed;
/*     */   int rooms;
/*     */   private final GETTER.GETTER_IMP<RoomCategories.RoomCategoryMain> cc;
/*     */   private final RoomCategories.RoomCategoryMain c;
/*     */   
/*     */   CatButt(RoomCategories.RoomCategoryMain c, GETTER.GETTER_IMP<RoomCategories.RoomCategoryMain> cc) {
/* 279 */     this.cc = cc;
/* 280 */     this.c = c;
/*     */     
/* 282 */     add((SPRITE)c.icon, 0, 0);
/*     */     
/* 284 */     addDownC(0, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 288 */             GFORMAT.i(text, UIPanelMain.CatButt.this.employees);
/*     */           }
/* 291 */         }).r(DIR.N));
/*     */ 
/*     */     
/* 294 */     addDownC(0, (SPRITE)new SPRITE.Imp(40, 10)
/*     */         {
/*     */           
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 299 */             if (UIPanelMain.CatButt.this.needed > 0) {
/* 300 */               GMeter.render(r, GMeter.C_REDGREEN, UIPanelMain.CatButt.this.employees / UIPanelMain.CatButt.this.needed, X1, X2, Y1, Y2);
/*     */             }
/*     */           }
/*     */         });
/* 304 */     pad(6, 8);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 310 */     super.render(r, ds);
/* 311 */     if (this.rooms == 0) {
/* 312 */       OPACITY.O50.bind();
/* 313 */       COLOR.BLACK.render(r, (RECTANGLE)body());
/* 314 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 320 */     this.cc.set(this.c);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 325 */     GBox b = (GBox)text;
/* 326 */     b.title(this.c.name);
/* 327 */     b.textLL(Dic.¤¤Employees);
/* 328 */     b.tab(6);
/* 329 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), this.employees, this.needed));
/* 330 */     b.NL();
/* 331 */     b.textLL(Dic.¤¤Amount);
/* 332 */     b.tab(6);
/* 333 */     b.add((SPRITE)GFORMAT.i(b.text(), this.rooms));
/* 334 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 339 */     this.employees = 0;
/* 340 */     this.needed = 0;
/* 341 */     this.rooms = 0;
/*     */     
/* 343 */     for (int ri = 0; ri < this.c.all().size(); ri++) {
/* 344 */       RoomBlueprintImp rb = (RoomBlueprintImp)this.c.all().get(ri);
/*     */       
/* 346 */       if (rb instanceof RoomBlueprintIns) {
/* 347 */         this.rooms++;
/* 348 */         RoomBlueprintIns<?> rr = (RoomBlueprintIns)rb;
/* 349 */         if (rr.employmentExtra() != null) {
/*     */ 
/*     */           
/* 352 */           this.employees += rr.employmentExtra().employed(null);
/* 353 */           this.needed += rr.employment().neededWorkers();
/*     */         } 
/*     */       } 
/*     */     } 
/* 357 */     selectedSet((this.cc.get() == this.c));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\UIPanelMain$CatButt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */