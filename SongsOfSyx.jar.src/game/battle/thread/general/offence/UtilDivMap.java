/*    */ package game.battle.thread.general.offence;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import init.constant.Config;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.DIMENSION;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.Bitmap2D;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ final class UtilDivMap
/*    */ {
/* 14 */   private final GTile[] tiles = new GTile[(Config.battle()).DIVISIONS_PER_ARMY];
/* 15 */   private int tileNewI = 0;
/* 16 */   private final GTile[][] grid = new GTile[(int)Math.ceil(SETT.TWIDTH / 16.0D)][(int)Math.ceil(SETT.THEIGHT / 16.0D)];
/* 17 */   private final Bitmap2D is = new Bitmap2D((DIMENSION)SETT.TILE_BOUNDS, false);
/* 18 */   private int[] xs = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/* 19 */   private int[] ys = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/*    */ 
/*    */   
/* 22 */   private final ArrayList<Div> res = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/* 23 */   private final LIST<Div> none = (LIST<Div>)new ArrayList(0);
/*    */ 
/*    */   
/*    */   public UtilDivMap() {
/* 27 */     for (int i = 0; i < this.tiles.length; i++) {
/* 28 */       this.tiles[i] = new GTile();
/*    */     }
/*    */   }
/*    */   
/*    */   public void clear() {
/* 33 */     this.tileNewI = 0;
/* 34 */     this.is.clear(); byte b; int i; GTile[][] arrayOfGTile;
/* 35 */     for (i = (arrayOfGTile = this.grid).length, b = 0; b < i; ) { GTile[] tt = arrayOfGTile[b];
/* 36 */       for (int j = 0; j < tt.length; j++)
/* 37 */         tt[j] = null; 
/*    */       b++; }
/*    */   
/*    */   }
/*    */   public void add(Div div) {
/* 42 */     int tx = div.centre().cUnitX() >> 6;
/* 43 */     int ty = div.centre().cUnitY() >> 6;
/* 44 */     if (!SETT.IN_BOUNDS(tx, ty))
/*    */       return; 
/* 46 */     this.xs[div.indexArmy()] = tx;
/* 47 */     this.ys[div.indexArmy()] = ty;
/* 48 */     this.is.set(tx, ty, true);
/* 49 */     int gx = tx / 16;
/* 50 */     int gy = ty / 16;
/* 51 */     GTile t = this.tiles[this.tileNewI++];
/* 52 */     t.div = div;
/* 53 */     t.next = this.grid[gy][gx];
/* 54 */     this.grid[gy][gx] = t;
/*    */   }
/*    */ 
/*    */   
/*    */   public LIST<Div> get(int tx, int ty) {
/* 59 */     if (!SETT.IN_BOUNDS(tx, ty))
/* 60 */       return this.none; 
/* 61 */     if (!this.is.is(tx, ty))
/* 62 */       return this.none; 
/* 63 */     this.res.clearSloppy();
/* 64 */     GTile t = this.grid[ty / 16][tx / 16];
/* 65 */     while (t != null && this.res.hasRoom()) {
/* 66 */       if (this.xs[t.div.indexArmy()] == tx && this.ys[t.div.indexArmy()] == ty)
/* 67 */         this.res.add(t.div); 
/* 68 */       t = t.next;
/*    */     } 
/* 70 */     return (LIST<Div>)this.res;
/*    */   }
/*    */   
/*    */   private static final class GTile {
/*    */     private Div div;
/*    */     private GTile next;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\offence\UtilDivMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */