/*     */ package view.interrupter;
/*     */ 
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.gui.misc.GBox;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Interrupter
/*     */ {
/*     */   boolean persistent;
/*     */   boolean desturbingfuck;
/*     */   private boolean pinned;
/*     */   private boolean last;
/*     */   InterManager addManager;
/*     */   
/*     */   protected Interrupter() {
/*  20 */     this(false, false, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Interrupter(boolean persistent, boolean pinned) {
/*  30 */     this(persistent, pinned, true);
/*     */   }
/*     */   
/*     */   protected Interrupter(boolean persistent, boolean pinned, boolean desturber) {
/*  34 */     this.persistent = !(!pinned && !persistent);
/*  35 */     this.pinned = pinned;
/*  36 */     this.desturbingfuck = desturber;
/*     */   }
/*     */   
/*     */   protected final boolean show(VIEW.ViewSub view) {
/*  40 */     return show(view.uiManager);
/*     */   }
/*     */   
/*     */   protected final boolean show(InterManager manager) {
/*  44 */     if (this.addManager == null) {
/*  45 */       manager.add(this);
/*  46 */       return true;
/*     */     } 
/*  48 */     return false;
/*     */   }
/*     */   
/*     */   protected void hide() {
/*  52 */     if (this.addManager != null) {
/*  53 */       this.addManager.remove(this);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */   
/*     */   protected void otherAdd(Interrupter other) {}
/*     */ 
/*     */   
/*     */   protected boolean DoWhateverAndallowOthersToDoWhatever() {
/*  66 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean hover(COORDINATE paramCOORDINATE, boolean paramBoolean);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void mouseClick(MButt paramMButt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean otherClick(MButt button) {
/*  91 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void hoverTimer(GBox paramGBox);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean render(Renderer paramRenderer, float paramFloat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract boolean update(float paramFloat);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void afterTick() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final boolean last() {
/* 124 */     return this.last;
/*     */   }
/*     */   
/*     */   public Interrupter lastSet() {
/* 128 */     this.last = true;
/* 129 */     return this;
/*     */   }
/*     */   
/*     */   public Interrupter persistantSet() {
/* 133 */     this.persistent = true;
/* 134 */     return this;
/*     */   }
/*     */   
/*     */   public Interrupter desturberSet() {
/* 138 */     this.desturbingfuck = true;
/* 139 */     return this;
/*     */   }
/*     */   
/*     */   final boolean isPersistent() {
/* 143 */     return this.persistent;
/*     */   }
/*     */   
/*     */   final boolean pinned() {
/* 147 */     return this.pinned;
/*     */   }
/*     */   
/*     */   public final Interrupter pin() {
/* 151 */     this.pinned = true;
/* 152 */     return this;
/*     */   }
/*     */   
/*     */   public final boolean isActivated() {
/* 156 */     return (this.addManager != null);
/*     */   }
/*     */   
/*     */   public InterManager manager() {
/* 160 */     return this.addManager;
/*     */   }
/*     */   
/*     */   public boolean canSave() {
/* 164 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\Interrupter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */