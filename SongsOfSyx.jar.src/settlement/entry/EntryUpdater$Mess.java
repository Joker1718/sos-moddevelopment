/*     */ package settlement.entry;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Mess
/*     */   extends MessageSection
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   ArrayCooShort coos;
/*     */   
/*     */   public Mess(EntryPoints po) {
/* 166 */     super(EntryUpdater.¤¤mTitle);
/* 167 */     this.coos = new ArrayCooShort(po.active().size() - po.reachable().size());
/* 168 */     for (EntryPoints.EntryPoint p : po.active()) {
/* 169 */       if (!p.reachable()) {
/* 170 */         this.coos.get().set(p.coo());
/* 171 */         this.coos.inc();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void make(GuiSection section) {
/* 178 */     paragraph(EntryUpdater.¤¤mDesc);
/*     */     
/* 180 */     this.coos.set(0);
/*     */     
/*     */     while (true) {
/* 183 */       section.addRelBody(8, DIR.S, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */           {
/* 185 */             final int tx = EntryUpdater.Mess.this.coos.get().x();
/* 186 */             final int ty = EntryUpdater.Mess.this.coos.get().y();
/*     */ 
/*     */             
/*     */             protected void clickA() {
/* 190 */               VIEW.s().activate();
/* 191 */               VIEW.s().getWindow().centerAtTile(this.tx, this.ty);
/*     */             }
/* 194 */           }).pad(20, 2));
/*     */       
/* 196 */       if (!this.coos.hasNext())
/*     */         return; 
/* 198 */       this.coos.next();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\EntryUpdater$Mess.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */