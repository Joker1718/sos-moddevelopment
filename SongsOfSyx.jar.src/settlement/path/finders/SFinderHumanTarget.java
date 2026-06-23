/*    */ package settlement.path.finders;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.type.CAUSE_LEAVES;
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import settlement.path.components.FindableDataSingle;
/*    */ import settlement.path.components.SComponent;
/*    */ import settlement.path.components.finder.SCompFinder;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ import view.sett.IDebugPanelSett;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PlacableSimpleTile;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class SFinderHumanTarget
/*    */ {
/*    */   private FindableDataSingle ff;
/*    */   private SCompFinder.SCompPatherFinder fin;
/*    */   
/*    */   public SFinderHumanTarget() {
/* 51 */     this.fin = new SCompFinder.SCompPatherFinder()
/*    */       {
/*    */         final ArrayList<Humanoid> all = new ArrayList(1);
/*    */         
/* 55 */         public boolean isInComponent(SComponent c, double distance) { return (SFinderHumanTarget.this.ff.get(c) > 0); }
/*    */       }; IDebugPanelSett.add((PLACABLE)new PlacableSimpleTile("kill targets") { public void place(int tx, int ty) { this.all.clear();
/*    */             SFinderHumanTarget.this.add(this.all, tx, ty, true, 128, Humanoid.TARGET_MAX);
/*    */             for (Humanoid h : this.all) {
/*    */               if (!h.isRemoved())
/*    */                 h.kill(true, CAUSE_LEAVES.MURDER()); 
/*    */             }  } public CharSequence isPlacable(int tx, int ty) { return ((SETT.PATH()).comps.zero.get(tx, ty) != null) ? null : E; } });
/* 62 */   } public void add(ArrayList<Humanoid> res, int cx, int cy, boolean player, int distance, int targetLimit) { this.ff = (SETT.PATH()).comps.data.people(player);
/* 63 */     LIST<SComponent> ls = (SETT.PATH()).comps.pather.fill(cx, cy, this.fin, distance).path();
/* 64 */     for (SComponent c : ls) {
/*    */       
/* 66 */       int x1 = CLAMP.i((c.centreX() & (c.level().size() - 1 ^ 0xFFFFFFFF)) - 1, 0, SETT.TWIDTH);
/* 67 */       int x2 = CLAMP.i(x1 + c.level().size() + 2, 0, SETT.TWIDTH);
/* 68 */       int y1 = CLAMP.i((c.centreY() & (c.level().size() - 1 ^ 0xFFFFFFFF)) - 1, 0, SETT.THEIGHT);
/* 69 */       int y2 = CLAMP.i(y1 + c.level().size() + 2, 0, SETT.THEIGHT);
/* 70 */       boolean found = false;
/* 71 */       for (int y = y1; y < y2; y++) {
/* 72 */         for (int x = x1; x < x2; x++) {
/* 73 */           for (ENTITY e : SETT.ENTITIES().getAtTile(x, y)) {
/* 74 */             if (e instanceof Humanoid) {
/* 75 */               Humanoid h = (Humanoid)e;
/* 76 */               if (h.indu().hostile() != player) {
/* 77 */                 found = true;
/* 78 */                 if (h.targets() < targetLimit) {
/* 79 */                   res.add(h);
/*    */                   
/* 81 */                   targetLimit--;
/* 82 */                   if (targetLimit <= 0 || !res.hasRoom()) {
/*    */                     return;
/*    */                   }
/*    */                 } 
/*    */               } 
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */       
/* 92 */       if (!found) {
/* 93 */         GAME.Notify("" + c.centreX() + " " + c.centreX() + " " + c.centreY() + " " + String.valueOf(this.ff.name) + " " + x1);
/*    */       }
/* 95 */       if (targetLimit <= 0 || !res.hasRoom())
/*    */         return; 
/*    */     }  }
/*    */ 
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderHumanTarget.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */