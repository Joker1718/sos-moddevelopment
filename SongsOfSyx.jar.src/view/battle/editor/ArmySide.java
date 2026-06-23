/*    */ package view.battle.editor;
/*    */ 
/*    */ import game.battle.util.DIV_SPEC;
/*    */ import game.raiding.RaiderArmy;
/*    */ import init.constant.Config;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import snake2d.util.file.Alloc;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import world.army.AD;
/*    */ 
/*    */ final class ArmySide {
/* 14 */   public ArrayList<DIV_SPEC> divs = new ArrayList((Config.battle()).DIVISIONS_PER_ARMY);
/* 15 */   public int[] artillery = Alloc.ii(AD.supplies().arts().size());
/*    */   
/*    */   void generate(double power) {
/* 18 */     RaiderArmy p = new RaiderArmy((Race)RACES.playable().rnd(), power, RND.rFloat());
/* 19 */     this.divs.clearSloppy();
/* 20 */     for (DIV_SPEC d : p.sdivs) {
/* 21 */       this.divs.add(d);
/*    */     }
/* 23 */     for (int i = 0; i < this.artillery.length; i++)
/* 24 */       this.artillery[i] = p.artillery[i]; 
/*    */   }
/*    */   
/*    */   void clear() {
/* 28 */     this.divs.clearSloppy();
/* 29 */     for (int i = 0; i < this.artillery.length; i++)
/* 30 */       this.artillery[i] = 0; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\editor\ArmySide.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */