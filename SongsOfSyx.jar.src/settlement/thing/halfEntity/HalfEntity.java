/*    */ package settlement.thing.halfEntity;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.datatypes.BODY_HOLDER;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.datatypes.RECTANGLEE;
/*    */ import snake2d.util.datatypes.Rec;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import util.gui.misc.GBox;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ public abstract class HalfEntity
/*    */   implements BODY_HOLDER
/*    */ {
/*    */   final Rec hitBox;
/*    */   HalfEntity renderNext;
/*    */   short gridX;
/*    */   short gridY;
/* 22 */   int index = -1;
/*    */   
/*    */   public HalfEntity(int hitBoxWidth, int hitBoxHeight) {
/* 25 */     this.hitBox = new Rec(0.0D, hitBoxWidth, 0.0D, hitBoxHeight);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final RECTANGLEE body() {
/* 34 */     return (RECTANGLEE)this.hitBox;
/*    */   }
/*    */   
/*    */   protected final void add() {
/* 38 */     this.renderNext = null;
/* 39 */     SETT.HALFENTS().add(this);
/* 40 */     addAction();
/*    */   }
/*    */   
/*    */   protected final void remove() {
/* 44 */     SETT.HALFENTS().remove(this);
/*    */     
/* 46 */     removeAction();
/*    */   }
/*    */   
/*    */   public final boolean added() {
/* 50 */     return (this.index != -1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void renderBelow(Renderer r, ShadowBatch s, float ds, int x, int y) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void renderAbove(Renderer r, ShadowBatch s, float ds, int x, int y) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void addAction() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void removeAction() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getZ() {
/* 77 */     return 0;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int index() {
/* 83 */     return this.index;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int ctx() {
/* 89 */     return body().cX() >> 6;
/*    */   }
/*    */   
/*    */   public int cty() {
/* 93 */     return body().cY() >> 6;
/*    */   }
/*    */   
/*    */   protected abstract void save(FilePutter paramFilePutter);
/*    */   
/*    */   protected abstract HalfEntity load(FileGetter paramFileGetter) throws IOException;
/*    */   
/*    */   public abstract void hoverInfo(GBox paramGBox);
/*    */   
/*    */   protected abstract void render(Renderer paramRenderer, ShadowBatch paramShadowBatch, float paramFloat, int paramInt1, int paramInt2);
/*    */   
/*    */   protected abstract void update(double paramDouble);
/*    */   
/*    */   protected abstract Factory<? extends HalfEntity> constructor();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\halfEntity\HalfEntity.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */