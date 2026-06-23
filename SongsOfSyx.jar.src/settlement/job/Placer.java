/*     */ package settlement.job;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ 
/*     */ 
/*     */ class Placer
/*     */   extends PlacableMulti
/*     */ {
/*     */   private final Job j;
/*     */   private final RESOURCE res;
/*     */   private final int resAmount;
/*     */   final CharSequence desc;
/*     */   
/*     */   public Placer(Job j, CharSequence desc) {
/*  31 */     this(j, null, 0, desc);
/*     */   }
/*     */   
/*     */   public Placer(Job j, RESOURCE res, int resAmount, CharSequence desc) {
/*  35 */     super(j.name, desc, j.icon);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 134 */     this.bOverwrite = (LIST<CLICKABLE>)new ArrayList(new GButt.Panel((SPRITE)(SPRITES.icons()).m.overwrite)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void renAction()
/*     */           {
/* 143 */             selectedSet(Job.overwrite);
/*     */           }
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 148 */             Job.overwrite = !Job.overwrite; }
/*     */         });
/*     */     this.j = j;
/*     */     this.res = res;
/*     */     this.resAmount = resAmount;
/*     */     this.desc = desc;
/*     */   } public LIST<CLICKABLE> getAdditionalButt() {
/* 155 */     return this.bOverwrite;
/*     */   }
/*     */   
/*     */   public CharSequence name() {
/*     */     return this.j.name;
/*     */   }
/*     */   
/*     */   public void updateRegardless(GameWindow window, AREA selected) {
/*     */     this.j.doSomethingExtraRender();
/*     */     super.updateRegardless(window, selected);
/*     */   }
/*     */   
/*     */   public final CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/*     */     return this.j.problem(tx, ty, Job.overwrite);
/*     */   }
/*     */   
/*     */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/*     */     place(tx, ty, this.j);
/*     */   }
/*     */   
/*     */   static void place(int tx, int ty, Job j) {
/*     */     if (!SETT.IN_BOUNDS(tx, ty))
/*     */       return; 
/*     */     int i = tx + ty * SETT.TWIDTH;
/*     */     Job old = (Job)(SETT.JOBS()).getter.get(i);
/*     */     if (old == j) {
/*     */       if (!(SETT.JOBS()).planMode.is() && (SETT.JOBS()).state.is(tx, ty, StateManager.State.DORMANT))
/*     */         (SETT.JOBS()).state.set(StateManager.State.RESERVABLE, (Job)(SETT.JOBS()).getter.get(i)); 
/*     */       return;
/*     */     } 
/*     */     if (old != null) {
/*     */       old.cancel(tx, ty);
/*     */       PlacerDelete.place(tx, ty);
/*     */     } 
/*     */     j.init(tx, ty);
/*     */     SETT.JOBS().set(j, tx, ty);
/*     */     if (!(SETT.JOBS()).planMode.is()) {
/*     */       (SETT.JOBS()).state.set(StateManager.State.RESERVABLE, (Job)(SETT.JOBS()).getter.get(i));
/*     */     } else {
/*     */       (SETT.JOBS()).state.set(StateManager.State.DORMANT, (Job)(SETT.JOBS()).getter.get(i));
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA a, PLACER_TYPE t, boolean isPlacable, boolean areaIsPlacable) {
/*     */     (SPRITES.cons()).BIG.dashedThick.render(r, mask, x, y);
/*     */   }
/*     */   
/*     */   public void placeInfo(GBox b, int okTiles, AREA a) {
/*     */     if (a.body().width() < 2 && a.body().height() < 2)
/*     */       return; 
/*     */     b.setArea(a.body());
/*     */     if (okTiles > 0 && this.res != null)
/*     */       b.setResource(this.res, (this.resAmount * okTiles)); 
/*     */   }
/*     */   
/*     */   public void hoverDesc(GBox box) {
/*     */     super.hoverDesc(box);
/*     */     if (this.res != null) {
/*     */       box.NL();
/*     */       box.setResource(this.res, this.resAmount);
/*     */     } 
/*     */     box.NL();
/*     */     this.j.extraHovInfo(box);
/*     */   }
/*     */   
/*     */   public PLACABLE getUndo() {
/*     */     return (PLACABLE)(SETT.JOBS()).tool_clear;
/*     */   }
/*     */   
/*     */   private static CharSequence ¤¤overwrite = "¤Overwrite";
/*     */   private static CharSequence ¤¤overdesc = "¤Overwrites other jobs or structures when placed.";
/*     */   protected final LIST<CLICKABLE> bOverwrite;
/*     */   
/*     */   static {
/*     */     D.ts(Placer.class);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\Placer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */