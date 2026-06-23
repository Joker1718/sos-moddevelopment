/*    */ package settlement.path.components;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.map.MAP_BOOLEAN;
/*    */ 
/*    */ public final class SComp0Level
/*    */   extends SComponentLevel
/*    */ {
/*    */   public static final int SIZE = 8;
/* 10 */   public static int startSize = SETT.TWIDTH / 8 * SETT.TWIDTH / 8;
/* 11 */   private final SComp0Factory factory = new SComp0Factory();
/* 12 */   private final SComp0Map map = new SComp0Map(this.factory);
/* 13 */   final SComp0Quads quads = new SComp0Quads(8);
/* 14 */   private final SComp0Updater updater = new SComp0Updater(this.map, this.factory, this);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void init() {
/* 22 */     this.factory.clear();
/* 23 */     this.map.clear();
/* 24 */     this.quads.changeAll();
/*    */   }
/*    */   
/*    */   public void update(int tx, int ty) {
/* 28 */     this.quads.setChangedAvailability(tx, ty);
/*    */   }
/*    */   
/*    */   public void changeSerives(int tx, int ty) {
/* 32 */     this.quads.setChangedServices(tx, ty);
/*    */   }
/*    */   
/*    */   public int comps() {
/* 36 */     return this.factory.maxAmount();
/*    */   }
/*    */   
/*    */   public SComponent comp(int i) {
/* 40 */     SComp0 c = this.factory.get(i);
/* 41 */     if (c != null && c.superComp() != null)
/* 42 */       return c; 
/* 43 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void update() {
/* 48 */     this.quads.update(this.updater);
/*    */   }
/*    */ 
/*    */   
/*    */   public int componentsMax() {
/* 53 */     return this.factory.maxAmount();
/*    */   }
/*    */ 
/*    */   
/*    */   public SComp0 get(int tile) {
/* 58 */     return this.map.get(tile);
/*    */   }
/*    */ 
/*    */   
/*    */   public SComp0 get(int tx, int ty) {
/* 63 */     return this.map.get(tx, ty);
/*    */   }
/*    */   
/*    */   public boolean uping() {
/* 67 */     return this.quads.updating();
/*    */   }
/*    */   
/*    */   public MAP_BOOLEAN updating() {
/* 71 */     return this.quads.updating;
/*    */   }
/*    */ 
/*    */   
/*    */   public SComponent getByIndex(int index) {
/* 76 */     return this.factory.get(index);
/*    */   }
/*    */ 
/*    */   
/*    */   public int level() {
/* 81 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public int size() {
/* 86 */     return 8;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SComp0Level.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */