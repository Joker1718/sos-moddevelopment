/*    */ package settlement.overlay;
/*    */ 
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.components.SComp0;
/*    */ import settlement.path.components.SComponent;
/*    */ import settlement.path.components.SComponentChecker;
/*    */ import settlement.path.components.SComponentEdge;
/*    */ import settlement.room.main.RoomInstance;
/*    */ import snake2d.PathTile;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import util.GUTIL;
/*    */ import util.rendering.RenderData;
/*    */ 
/*    */ final class RoomRadius
/*    */   extends Addable {
/*    */   private RoomInstance ins;
/*    */   private int radius;
/*    */   private final SComponentChecker comps;
/*    */   
/*    */   RoomRadius(SComponentChecker comps) {
/* 22 */     super(null, null, null, null, true, false);
/* 23 */     this.exclusive = true;
/* 24 */     this.comps = comps;
/*    */   }
/*    */ 
/*    */   
/*    */   public void add(RoomInstance ins, int radius) {
/* 29 */     this.ins = ins;
/* 30 */     this.radius = radius;
/* 31 */     add();
/*    */   }
/*    */ 
/*    */   
/*    */   public void initBelow(RenderData data) {
/* 36 */     GUTIL.flooder().init(this);
/*    */     
/* 38 */     for (COORDINATE c : this.ins.body()) {
/* 39 */       if (this.ins.is(c))
/*    */       {
/* 41 */         GUTIL.flooder().pushSloppy(c, 0.0D);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 46 */     this.comps.init();
/* 47 */     while (GUTIL.flooder().hasMore()) {
/* 48 */       PathTile t = GUTIL.flooder().pollSmallest();
/* 49 */       if (t.getValue() > this.radius)
/*    */         continue; 
/* 51 */       SComponent c = (SComponent)(SETT.PATH()).comps.zero.get((COORDINATE)t);
/* 52 */       if (c == null)
/*    */         continue; 
/* 54 */       this.comps.isSetAndSet(c);
/* 55 */       SComponentEdge e = c.edgefirst();
/*    */       
/* 57 */       while (e != null) {
/* 58 */         double dist = e.distance();
/* 59 */         GUTIL.flooder().pushSmaller(e.to().centreX(), e.to().centreY(), t.getValue() + dist);
/* 60 */         e = e.next();
/*    */       } 
/*    */     } 
/*    */     
/* 64 */     GUTIL.flooder().done();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean render(Renderer r, RenderData.RenderIterator it) {
/* 70 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 75 */     SComp0 sComp0 = (SETT.PATH()).comps.zero.get(it.tile());
/* 76 */     if (sComp0 != null && this.comps.isSet(sComp0.index())) {
/* 77 */       renderUnder(1.0D, r, it, false);
/*    */     } else {
/* 79 */       renderUnder(0.0D, r, it, false);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void finishBelow() {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\RoomRadius.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */