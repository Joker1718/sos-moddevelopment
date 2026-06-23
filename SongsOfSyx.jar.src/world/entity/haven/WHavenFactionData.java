/*    */ package world.entity.haven;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import world.WORLD;
/*    */ 
/*    */ final class WHavenFactionData
/*    */ {
/*    */   final RaceData[] all;
/*    */   boolean dirty;
/*    */   private final int fi;
/*    */   
/*    */   public WHavenFactionData(WHavens havens, int fi) {
/* 14 */     this.fi = fi;
/* 15 */     this.all = new RaceData[havens.types.size()];
/* 16 */     for (int i = 0; i < this.all.length; i++)
/* 17 */       this.all[i] = new RaceData(); 
/*    */   }
/*    */   
/*    */   void init() {
/* 21 */     if (!this.dirty)
/*    */       return; 
/* 23 */     Faction f = FACTIONS.getByIndex(this.fi);
/* 24 */     this.dirty = false; byte b; int j; RaceData[] arrayOfRaceData;
/* 25 */     for (j = (arrayOfRaceData = this.all).length, b = 0; b < j; ) { RaceData d = arrayOfRaceData[b];
/* 26 */       d.clear(); b++; }
/* 27 */      if (!f.isActive()) {
/*    */       return;
/*    */     }
/* 30 */     for (int i = 0; i < f.realm().regions(); i++) {
/* 31 */       for (WHaven h : (WORLD.ENTITIES()).havens.fill(f.realm().region(i))) {
/* 32 */         this.all[h.type().index()].add(h);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   static class RaceData
/*    */   {
/*    */     int camps;
/*    */     
/*    */     int pop;
/*    */     double replenish;
/*    */     
/*    */     public void clear() {
/* 46 */       this.camps = 0;
/* 47 */       this.pop = 0;
/* 48 */       this.replenish = 0.0D;
/*    */     }
/*    */     public void add(WHaven ii) {
/* 51 */       this.camps++;
/* 52 */       this.pop += ii.pop();
/* 53 */       this.replenish += ii.replenish();
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\haven\WHavenFactionData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */