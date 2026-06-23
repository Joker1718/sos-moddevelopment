/*     */ package game.faction.diplomacy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class List
/*     */ {
/*  82 */   private int[] state = Alloc.ii(FACTIONS.MAX());
/*     */   private Faction cf;
/*  84 */   private final ArrayList<Faction> tmp = new ArrayList(FACTIONS.MAX());
/*  85 */   private final ArrayList<FactionNPC> player = new ArrayList(FACTIONS.MAX());
/*     */   
/*     */   public LIST<? extends Faction> all(Faction f) {
/*  88 */     if (f == FACTIONS.player()) {
/*  89 */       if (this.state[f.index()] != DIP.s.stateI) {
/*  90 */         this.state[f.index()] = DIP.s.stateI;
/*  91 */         this.player.clearSloppy();
/*  92 */         for (FactionNPC o : FACTIONS.NPCs()) {
/*  93 */           if (f != o && DipStance.this.is((Faction)o, f)) {
/*  94 */             this.player.add(o);
/*     */           }
/*     */         } 
/*     */       } 
/*  98 */       return (LIST)this.player;
/*     */     } 
/* 100 */     if (this.cf != f || this.state[f.index()] != DIP.s.stateI) {
/* 101 */       this.cf = f;
/* 102 */       this.state[f.index()] = DIP.s.stateI;
/* 103 */       this.tmp.clearSloppy();
/* 104 */       for (Faction o : FACTIONS.active()) {
/* 105 */         if (f != o && DipStance.this.is(o, f))
/* 106 */           this.tmp.add(o); 
/*     */       } 
/*     */     } 
/* 109 */     return (LIST<? extends Faction>)this.tmp;
/*     */   }
/*     */   
/*     */   public LIST<FactionNPC> player() {
/* 113 */     all((Faction)FACTIONS.player());
/* 114 */     return (LIST<FactionNPC>)this.player;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\DipStance$List.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */