/*     */ package world.entity;
/*     */ 
/*     */ import game.faction.Faction;
/*     */ import java.io.IOException;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.RECTANGLEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import util.rendering.ShadowBatch;
/*     */ import world.WORLD;
/*     */ import world.map.pathing.WPath;
/*     */ 
/*     */ public abstract class WEntity
/*     */   implements BODY_HOLDER
/*     */ {
/*     */   final Rec hitBox;
/*     */   WEntity renderNext;
/*     */   WEntity regionNext;
/*     */   short gridX;
/*     */   short gridY;
/*  24 */   short regionI = -1;
/*  25 */   int index = -1;
/*     */   
/*     */   public WEntity(int hitBoxWidth, int hitBoxHeight) {
/*  28 */     this.hitBox = new Rec(0.0D, hitBoxWidth, 0.0D, hitBoxHeight);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final RECTANGLEE body() {
/*  37 */     return (RECTANGLEE)this.hitBox;
/*     */   }
/*     */   
/*     */   protected final void add() {
/*  41 */     this.renderNext = null;
/*  42 */     this.regionNext = null;
/*  43 */     this.regionI = -1;
/*  44 */     WORLD.ENTITIES().add(this);
/*  45 */     addAction();
/*     */   }
/*     */   
/*     */   protected final void remove() {
/*  49 */     WORLD.ENTITIES().remove(this);
/*  50 */     removeAction();
/*     */   }
/*     */   
/*     */   public final boolean added() {
/*  54 */     return (this.index != -1);
/*     */   }
/*     */   
/*     */   public final int index() {
/*  58 */     return this.index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void renderGround(Renderer r, ShadowBatch s, float ds, int x, int y) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void handleFow() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void addAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void removeAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getZ() {
/*  81 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public short ctx() {
/*  87 */     return (short)(body().cX() >> 6);
/*     */   }
/*     */   
/*     */   public short cty() {
/*  91 */     return (short)(body().cY() >> 6);
/*     */   }
/*     */ 
/*     */   
/*     */   public Faction faction() {
/*  96 */     return null;
/*     */   }
/*     */   
/*     */   public WPath path() {
/* 100 */     return null;
/*     */   }
/*     */   
/*     */   protected abstract void save(FilePutter paramFilePutter);
/*     */   
/*     */   protected abstract WEntity load(FileGetter paramFileGetter) throws IOException;
/*     */   
/*     */   protected abstract void renderBelowTerrain(Renderer paramRenderer, ShadowBatch paramShadowBatch, float paramFloat, int paramInt1, int paramInt2);
/*     */   
/*     */   protected abstract void renderAboveTerrain(Renderer paramRenderer, ShadowBatch paramShadowBatch, float paramFloat, int paramInt1, int paramInt2);
/*     */   
/*     */   protected abstract void update(double paramDouble);
/*     */   
/*     */   protected abstract WEntityConstructor<? extends WEntity> constructor();
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\WEntity.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */