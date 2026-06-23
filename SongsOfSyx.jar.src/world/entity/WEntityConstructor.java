/*    */ package world.entity;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class WEntityConstructor<T extends WEntity>
/*    */ {
/*    */   final int index;
/* 19 */   private final ArrayList<T> tmp = new ArrayList(64);
/*    */   protected final boolean fast;
/*    */   
/*    */   protected WEntityConstructor(LISTE<WEntityConstructor<? extends WEntity>> all, boolean fast) {
/* 23 */     this.index = all.add(this);
/* 24 */     this.fast = fast;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract T create();
/*    */ 
/*    */ 
/*    */   
/*    */   protected abstract void clear();
/*    */ 
/*    */ 
/*    */   
/*    */   protected void save(FilePutter file) {}
/*    */ 
/*    */ 
/*    */   
/*    */   protected void load(FileGetter file) throws IOException {}
/*    */ 
/*    */   
/*    */   protected void update(double ds) {}
/*    */ 
/*    */   
/*    */   public void fill(LISTE<T> res, Region reg) {
/* 48 */     WEntity e = WORLD.ENTITIES().regFirst(reg);
/* 49 */     while (e != null && res.hasRoom()) {
/* 50 */       if (e.constructor() == this) {
/* 51 */         res.add(e);
/*    */       }
/* 53 */       e = e.regionNext;
/*    */     } 
/*    */   }
/*    */   
/*    */   public LIST<T> fill(Region reg) {
/* 58 */     this.tmp.clearSloppy();
/* 59 */     fill((LISTE<T>)this.tmp, reg);
/* 60 */     return (LIST<T>)this.tmp;
/*    */   }
/*    */   
/*    */   public LIST<T> fillTile(int tx, int ty) {
/* 64 */     return fill(tx * 64, (tx + 1) * 64, ty * 64, (ty + 1) * 64);
/*    */   }
/*    */   
/*    */   public LIST<T> fillTiles(int tx1, int tx2, int ty1, int ty2) {
/* 68 */     return fill(tx1 * 64, tx2 * 64, ty1 * 64, ty2 * 64);
/*    */   }
/*    */   
/*    */   public LIST<T> fillTiles(RECTANGLE tiles) {
/* 72 */     return fill(tiles.x1() * 64, tiles.x2() * 64, tiles.y1() * 64, tiles.y2() * 64);
/*    */   }
/*    */   
/*    */   public LIST<T> fill(int x1, int x2, int y1, int y2) {
/* 76 */     this.tmp.clearSloppy();
/* 77 */     fill((LISTE<T>)this.tmp, x1, x2, y1, y2);
/* 78 */     return (LIST<T>)this.tmp;
/*    */   }
/*    */ 
/*    */   
/*    */   public LIST<T> fill(LISTE<T> tmp, int x1, int x2, int y1, int y2) {
/* 83 */     for (WEntity e : WORLD.ENTITIES().fill(x1, x2, y1, y2)) {
/* 84 */       if (e.constructor() == this)
/* 85 */         tmp.add(e); 
/*    */     } 
/* 87 */     return (LIST<T>)tmp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\WEntityConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */