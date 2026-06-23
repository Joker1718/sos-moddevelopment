/*     */ package view.ui.div;
/*     */ 
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.INT;
/*     */ import util.text.Dic;
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
/*     */ class Stats
/*     */   implements DIV_SPEC.DIV_SPECE
/*     */ {
/* 489 */   public final INT.IntImp[] training = new INT.IntImp[(STATS.BATTLE()).TRAINING_ALL.size()];
/* 490 */   public final Gear[] gear = new Gear[STATS.EQUIP().BATTLE_ALL().size()];
/* 491 */   public final INT.IntImp men = new INT.IntImp(1, (int)Math.ceil(((Config.battle()).MEN_PER_DIVISION / 10)));
/* 492 */   public final INT.IntImp experience = new INT.IntImp(0, 4);
/* 493 */   public INT.IntImp race = new INT.IntImp();
/* 494 */   public Str name = (new Str(24)).add(Dic.¤¤rename);
/* 495 */   public INT.IntImp faction = new INT.IntImp();
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
/*     */   private final double[] slots;
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
/*     */   public Stats(final double maxTraining) {
/* 520 */     this.slots = new double[8]; this.men.setD(0.75D); int i; for (i = 0; i < this.gear.length; i++)
/*     */       this.gear[i] = new Gear(i, this.gear);  for (i = 0; i < this.training.length; i++) { this.training[i] = new INT.IntImp(0, 10) { public int max() { int am = (int)(maxTraining * 10.0D); byte b; int i; INT.IntImp[] arrayOfIntImp; for (i = (arrayOfIntImp = UIDivEditor.Stats.this.training).length, b = 0; b < i; ) { INT.IntImp ii = arrayOfIntImp[b]; if (ii != this)
/*     */                 am -= ii.get();  b++; }  return CLAMP.i(am, 0, 10); } }; } 
/* 523 */   } private void setSlots() { Arrays.fill(this.slots, 0.0D); byte b; int i; Gear[] arrayOfGear;
/* 524 */     for (i = (arrayOfGear = this.gear).length, b = 0; b < i; ) { Gear g = arrayOfGear[b];
/* 525 */       if (g.get() > 0)
/* 526 */         for (int si = 0; si < this.slots.length; si++) {
/* 527 */           this.slots[si] = this.slots[si] + ((EquipBattle)STATS.EQUIP().BATTLE_ALL().get(g.gi)).slotUse(si);
/*     */         } 
/*     */       b++; }
/*     */      }
/*     */ 
/*     */   
/*     */   public boolean canSet(EquipBattle m) {
/* 534 */     if (!m.allowed((Race)RACES.all().get(this.race.get())))
/* 535 */       return false; 
/* 536 */     setSlots();
/* 537 */     for (int si = 0; si < this.slots.length; si++) {
/* 538 */       if (this.slots[si] + m.slotUse(si) > 1.0D) {
/* 539 */         return false;
/*     */       }
/*     */     } 
/* 542 */     return true;
/*     */   }
/*     */   
/*     */   private class Gear
/*     */     extends INT.IntImp {
/*     */     private final int gi;
/*     */     private final Gear[] other;
/*     */     
/*     */     Gear(int gi, Gear[] other) {
/* 551 */       super(0, ((EquipBattle)STATS.EQUIP().BATTLE_ALL().get(gi)).max());
/* 552 */       this.gi = gi;
/* 553 */       this.other = other;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int t) {
/* 558 */       EquipBattle s = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(this.gi);
/* 559 */       if (t > 0) {
/* 560 */         Arrays.fill(UIDivEditor.Stats.this.slots, 0.0D); byte b; int i; Gear[] arrayOfGear;
/* 561 */         for (i = (arrayOfGear = UIDivEditor.Stats.this.gear).length, b = 0; b < i; ) { Gear g = arrayOfGear[b];
/* 562 */           if (g.get() > 0)
/* 563 */             for (int si = 0; si < UIDivEditor.Stats.this.slots.length; si++) {
/* 564 */               if (g != this)
/* 565 */                 UIDivEditor.Stats.this.slots[si] = UIDivEditor.Stats.this.slots[si] + ((EquipBattle)STATS.EQUIP().BATTLE_ALL().get(g.gi)).slotUse(si); 
/*     */             }  
/*     */           b++; }
/*     */         
/* 569 */         for (int oi = 0; oi < STATS.EQUIP().BATTLE_ALL().size(); oi++) {
/* 570 */           EquipBattle o = (EquipBattle)STATS.EQUIP().BATTLE_ALL().get(oi);
/* 571 */           if (s != o) {
/* 572 */             for (int si = 0; si < UIDivEditor.Stats.this.slots.length; si++) {
/* 573 */               if (UIDivEditor.Stats.this.slots[si] + s.slotUse(si) > 1.0D && o.slotUse(si) > 0.0D && this.other[oi].get() > 0) {
/* 574 */                 this.other[o.indexMilitary()].set(0);
/* 575 */                 UIDivEditor.Stats.this.slots[si] = UIDivEditor.Stats.this.slots[si] - o.slotUse(si);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 587 */       super.set(t);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double training(StatsBattle.StatTraining tr) {
/* 594 */     return this.training[tr.tIndex].get() / 10.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public INT.IntImp equipi(EquipBattle e) {
/* 602 */     return this.gear[e.indexMilitary()];
/*     */   }
/*     */   
/*     */   public INT.IntImp traini(StatsBattle.StatTraining tr) {
/* 606 */     return this.training[tr.tIndex];
/*     */   }
/*     */ 
/*     */   
/*     */   public double equip(EquipBattle e) {
/* 611 */     return this.gear[e.indexMilitary()].getD();
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/* 616 */     return this.men.get() * 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public Race race() {
/* 621 */     return (Race)RACES.all().get(this.race.get());
/*     */   }
/*     */ 
/*     */   
/*     */   public void raceSet(Race race) {
/* 626 */     this.race.set(race.index);
/* 627 */     UIDivEditor.this.race.set(race);
/*     */   }
/*     */ 
/*     */   
/*     */   public double experience() {
/* 632 */     return this.experience.getD();
/*     */   }
/*     */ 
/*     */   
/*     */   public Faction faction() {
/* 637 */     return FACTIONS.getByIndex(this.faction.get());
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 642 */     return (CharSequence)this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public int bannerI() {
/* 647 */     return UIDivEditor.this.ee.bannerI(); } public void clear() {
/*     */     byte b;
/*     */     int i;
/*     */     Gear[] arrayOfGear;
/* 651 */     for (i = (arrayOfGear = this.gear).length, b = 0; b < i; ) { INT.IntImp ii = arrayOfGear[b];
/* 652 */       ii.set(0); b++; }
/* 653 */      INT.IntImp[] arrayOfIntImp; for (i = (arrayOfIntImp = this.training).length, b = 0; b < i; ) { INT.IntImp ii = arrayOfIntImp[b];
/* 654 */       ii.set(0); b++; }
/* 655 */      this.experience.set(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void menSet(int men) {
/* 660 */     this.men.setD(men / (Config.battle()).MEN_PER_DIVISION);
/*     */   }
/*     */ 
/*     */   
/*     */   public void experienceSet(double experience) {
/* 665 */     this.experience.setD(experience);
/*     */   }
/*     */ 
/*     */   
/*     */   public Str nameE() {
/* 670 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public void bannerISet(int bannerI) {
/* 675 */     UIDivEditor.this.ee.bannerISet(bannerI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void trainingSet(StatsBattle.StatTraining tr, double d) {
/* 682 */     this.training[tr.tIndex].set((int)Math.round(d * 10.0D));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void equipSet(EquipBattle e, double d) {
/* 688 */     this.gear[e.indexMilitary()].setD(d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void factionSet(Faction faction) {
/* 694 */     this.faction.set((faction == null) ? 0 : faction.index());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivEditor$Stats.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */