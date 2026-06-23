/*     */ package settlement.entity.humanoid;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimple;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends PlacableSimple
/*     */ {
/*     */   private CAUSE_LEAVE cause;
/*     */   ArrayList<CLICKABLE> butts;
/*     */   
/*     */   null(CharSequence $anonymous0, CharSequence $anonymous1) {
/*  72 */     super($anonymous0, $anonymous1);
/*     */     
/*  74 */     this.cause = CAUSE_LEAVES.AGE();
/*  75 */     this.butts = new ArrayList(CAUSE_LEAVES.ALL().size());
/*     */ 
/*     */ 
/*     */     
/*  79 */     for (CAUSE_LEAVE l : CAUSE_LEAVES.ALL()) {
/*     */       
/*  81 */       this.butts.add((new GButt.Panel((SPRITE)(SPRITES.icons()).s.dot)
/*     */           {
/*     */             protected void clickA() {
/*  84 */               Humanoids.null.this.cause = l;
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/*  89 */               selectedSet((Humanoids.null.this.cause == l));
/*     */             }
/*  91 */           }).hoverInfoSet(l.desc));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/*  98 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 103 */     return (SPRITE)(SPRITES.icons()).m.cancel;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int x, int y) {
/* 109 */     for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/* 110 */       if (e instanceof Humanoid) {
/* 111 */         ((Humanoid)e).kill(false, this.cause);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int x, int y) {
/* 119 */     for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/* 120 */       if (e instanceof Humanoid) {
/* 121 */         return null;
/*     */       }
/*     */     } 
/* 124 */     return E;
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<CLICKABLE> getAdditionalButt() {
/* 129 */     return (LIST<CLICKABLE>)this.butts;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\Humanoids$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */