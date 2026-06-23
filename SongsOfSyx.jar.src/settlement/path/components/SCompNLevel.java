/*    */ package settlement.path.components;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SCompNLevel
/*    */   extends SComponentLevel
/*    */ {
/*    */   private final int level;
/*    */   private final SCompNFactory factory;
/*    */   private final SCompNUpdater updater;
/*    */   private final int size;
/*    */   
/*    */   public SCompNLevel(SComponentLevel prev, int level, int size) {
/* 17 */     this.level = level;
/* 18 */     this.factory = new SCompNFactory(level, size);
/* 19 */     this.size = size;
/* 20 */     this.updater = new SCompNUpdater(this, this.factory, prev, size);
/*    */   }
/*    */   
/*    */   void remove(SComponent toBeRemoved) {
/* 24 */     this.updater.remove(toBeRemoved);
/*    */   }
/*    */   
/*    */   void addNew(SComponent newSubComponent) {
/* 28 */     this.updater.add(newSubComponent);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SComponent get(int tile) {
/* 34 */     SComponent c = (SComponent)((SComponentLevel)(SETT.PATH()).comps.all.get(this.level - 1)).get(tile);
/* 35 */     if (c == null)
/* 36 */       return null; 
/* 37 */     return c.superComp();
/*    */   }
/*    */ 
/*    */   
/*    */   public SComponent get(int tx, int ty) {
/* 42 */     if (SETT.IN_BOUNDS(tx, ty))
/* 43 */       return get(tx + ty * SETT.TWIDTH); 
/* 44 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public int componentsMax() {
/* 49 */     return this.factory.maxAmount();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SComponent getByIndex(int index) {
/* 55 */     return this.factory.get(index);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update() {
/* 61 */     this.updater.update();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int level() {
/* 67 */     return this.level;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int size() {
/* 73 */     return this.size;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void init() {
/* 79 */     this.factory.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\components\SCompNLevel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */