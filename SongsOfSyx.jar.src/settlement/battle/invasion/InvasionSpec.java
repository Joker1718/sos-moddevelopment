/*    */ package settlement.battle.invasion;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.battle.util.DIV_SPEC;
/*    */ import game.battle.util.DivGeneration;
/*    */ import init.constant.Config;
/*    */ import init.trade.TR_STOCKPILE;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.file.FileGetter;
/*    */ import snake2d.util.file.FilePutter;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class InvasionSpec
/*    */ {
/* 20 */   public final TR_STOCKPILE loot = new TR_STOCKPILE();
/* 21 */   public final ArrayList<DivGeneration> divs = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/* 22 */   public final int[] artillery = Alloc.ii((SETT.ROOMS()).ARTILLERY.size());
/* 23 */   public int wy = -1; public int wx;
/* 24 */   public int fi = -1;
/*    */   boolean canBeAttacked = true;
/* 26 */   int ref = -1;
/*    */   
/*    */   public double power;
/*    */ 
/*    */   
/*    */   public InvasionSpec() {}
/*    */   
/*    */   public InvasionSpec(FileGetter f) throws IOException {
/* 34 */     this.loot.load(f);
/* 35 */     int am = f.i();
/* 36 */     for (int i = 0; i < am; i++)
/* 37 */       this.divs.add(new DivGeneration(f)); 
/* 38 */     f.isE(this.artillery);
/* 39 */     this.wx = f.i();
/* 40 */     this.wy = f.i();
/* 41 */     this.fi = f.i();
/* 42 */     this.canBeAttacked = f.bool();
/* 43 */     this.ref = f.i();
/* 44 */     this.power = f.d();
/*    */   }
/*    */   
/*    */   public void add(DivGeneration g) {
/* 48 */     this.power = (GAME.battle()).power.get((DIV_SPEC)g.makeSpec());
/* 49 */     this.divs.add(g);
/*    */   }
/*    */   
/*    */   public void add(LIST<DivGeneration> g) {
/* 53 */     this.power = 0.0D;
/* 54 */     this.divs.clearSloppy();
/* 55 */     for (DivGeneration d : g)
/* 56 */       add(d); 
/*    */   }
/*    */   
/*    */   public void save(FilePutter file) {
/* 60 */     this.loot.save(file);
/* 61 */     file.i(this.divs.size());
/* 62 */     for (DivGeneration g : this.divs)
/* 63 */       g.save(file); 
/* 64 */     file.isE(this.artillery);
/* 65 */     file.i(this.wx);
/* 66 */     file.i(this.wy);
/* 67 */     file.i(this.fi);
/* 68 */     file.bool(this.canBeAttacked);
/* 69 */     file.i(this.ref);
/* 70 */     file.d(this.power);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\InvasionSpec.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */