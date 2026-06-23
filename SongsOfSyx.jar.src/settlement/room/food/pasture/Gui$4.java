/*     */ package settlement.room.food.pasture;
/*     */ 
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   private final ACTION yes;
/*     */   
/*     */   null(CharSequence $anonymous0) {
/* 118 */     super($anonymous0);
/* 119 */     this.yes = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 123 */           ((PastureInstance)getter.get()).slaughterAll();
/*     */         }
/*     */       };
/*     */   }
/*     */   protected void clickA() {
/* 128 */     (VIEW.inters()).yesNo.activate(Gui.¤¤SlaughterAllDesc, this.yes, ACTION.NOP, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 133 */     GBox b = (GBox)text;
/* 134 */     double produce = ((ROOM_PASTURE)Gui.access$2(Gui.this)).slaughterAmount(false, ((PastureInstance)getter.get()).industry()) * (((PastureInstance)getter.get()).animalsCurrent - ((PastureInstance)getter.get()).animalsCubs);
/* 135 */     produce += ((ROOM_PASTURE)Gui.access$2(Gui.this)).slaughterAmount(true, ((PastureInstance)getter.get()).industry()) * ((PastureInstance)getter.get()).animalsCubs;
/*     */     
/* 137 */     for (IndustryResource r : ((PastureInstance)getter.get()).industry().outs()) {
/* 138 */       if (r.resource == RESOURCES.LIVESTOCK())
/*     */         continue; 
/* 140 */       double am = produce * r.rate;
/*     */       
/* 142 */       b.add((SPRITE)r.resource.icon());
/* 143 */       b.text(r.resource.name);
/* 144 */       b.tab(7);
/* 145 */       b.add((SPRITE)GFORMAT.f0(b.text(), am));
/* 146 */       b.NL();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\Gui$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */