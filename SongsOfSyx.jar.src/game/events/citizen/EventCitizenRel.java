/*     */ package game.events.citizen;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.religion.RELIGIONS;
/*     */ import init.religion.Religion;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsReligion;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StrInserter;
/*     */ import util.text.D;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ final class EventCitizenRel
/*     */   implements EventCitizen.SMALL_EVENT {
/*  26 */   private static CharSequence ¤¤title = "War of the faiths";
/*  27 */   private static CharSequence ¤¤descRel = "Due to low happiness, a local dispute between two citizens of opposing faiths has spread across the whole city. Followers of {RELIGION_A} and {RELIGION_B} are now at each others throats and fighting each other wherever they meet. We must fix our happiness issues before this spreads any further.";
/*  28 */   private static CharSequence ¤¤descRel2 = "The tension between religious factions have spread. Followers of {RELIGION_A} and {RELIGION_B} are now also at odds, and fighting each other wherever they meet.";
/*     */   
/*  30 */   private final StrInserter<Religion> irA = new StrInserter<Religion>("RELIGION_A")
/*     */     {
/*     */       protected void set(Religion t, Str str)
/*     */       {
/*  34 */         str.add(t.diety);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  39 */   private final StrInserter<Religion> irB = new StrInserter<Religion>("RELIGION_B")
/*     */     {
/*     */       protected void set(Religion t, Str str)
/*     */       {
/*  43 */         str.add(t.diety);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private double timer;
/*  49 */   private final Bitmap1D map = new Bitmap1D(RELIGIONS.ALL().size(), false);
/*     */   
/*     */   static {
/*  52 */     D.ts(EventCitizenRel.class);
/*     */   }
/*     */ 
/*     */   
/*     */   EventCitizenRel() {
/*  57 */     IDebugPanelSett.add("Event: race war", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  61 */             EventCitizenRel.this.event(0, FACTIONS.player().race());
/*     */           }
/*     */         });
/*  64 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/*  70 */     this.timer -= ds;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(int am, Race race) {
/*  75 */     if (this.timer <= 0.0D)
/*  76 */       this.map.clear(); 
/*  77 */     return spawnRel(race);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean spawnRel(Race race) {
/*  82 */     Religion a = rel(race);
/*  83 */     if (a == null)
/*  84 */       return false; 
/*  85 */     Religion b = ranRel(a);
/*  86 */     if (b == null) {
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     this.map.set(a.index(), true);
/*  91 */     this.map.set(b.index(), true);
/*  92 */     Str s = new Str((this.timer > 0.0D) ? ¤¤descRel2 : ¤¤descRel);
/*  93 */     this.irA.insert(a, s);
/*  94 */     this.irB.insert(b, s);
/*  95 */     this.timer = (TIME.secondsPerDay() * (1.0F + RND.rFloat(2.0D)));
/*  96 */     (new MessageText(¤¤title, (CharSequence)s)).send();
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   private Religion rel(Race race) {
/* 101 */     double max = 0.0D; int ri;
/* 102 */     for (ri = 0; ri < RELIGIONS.ALL().size(); ri++) {
/* 103 */       Religion r = (Religion)RELIGIONS.ALL().get(ri);
/* 104 */       if (((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(r.index())).followers.data(HCLASSES.CITIZEN()).get(race) > 0) {
/* 105 */         max += ((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(r.index())).followers.data(HCLASSES.CITIZEN()).get(race);
/*     */       }
/*     */     } 
/*     */     
/* 109 */     if (max == 0.0D) {
/* 110 */       return null;
/*     */     }
/* 112 */     max *= RND.rFloat();
/*     */     
/* 114 */     for (ri = 0; ri < RELIGIONS.ALL().size(); ri++) {
/* 115 */       Religion r = (Religion)RELIGIONS.ALL().get(ri);
/* 116 */       if (((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(r.index())).followers.data(HCLASSES.CITIZEN()).get(race) > 0) {
/* 117 */         max -= ((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(r.index())).followers.data(HCLASSES.CITIZEN()).get(race);
/* 118 */         if (max <= 0.0D) {
/* 119 */           return r;
/*     */         }
/*     */       } 
/*     */     } 
/* 123 */     return null;
/*     */   }
/*     */   
/*     */   private Religion ranRel(Religion other) {
/* 127 */     double max = 0.0D; int ri;
/* 128 */     for (ri = 0; ri < RELIGIONS.ALL().size(); ri++) {
/* 129 */       Religion r = (Religion)RELIGIONS.ALL().get(ri);
/* 130 */       if (r != other && ((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(r.index())).followers.data(HCLASSES.CITIZEN()).get(null) > 0) {
/* 131 */         max += ((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(r.index())).followers.data(HCLASSES.CITIZEN()).get(null);
/*     */       }
/*     */     } 
/*     */     
/* 135 */     if (max == 0.0D) {
/* 136 */       return null;
/*     */     }
/* 138 */     max *= RND.rFloat();
/*     */     
/* 140 */     for (ri = 0; ri < RELIGIONS.ALL().size(); ri++) {
/* 141 */       Religion r = (Religion)RELIGIONS.ALL().get(ri);
/* 142 */       if (r != other && ((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(r.index())).followers.data(HCLASSES.CITIZEN()).get(null) > 0) {
/* 143 */         max -= ((StatsReligion.StatReligion)(STATS.RELIGION()).ALL.get(r.index())).followers.data(HCLASSES.CITIZEN()).get(null);
/* 144 */         if (max <= 0.0D) {
/* 145 */           return r;
/*     */         }
/*     */       } 
/*     */     } 
/* 149 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isAtOdds(Humanoid a, Humanoid b) {
/* 153 */     if (this.timer <= 0.0D)
/* 154 */       return false; 
/* 155 */     Religion ra = ((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(a.indu())).religion;
/* 156 */     Religion rb = ((StatsReligion.StatReligion)(STATS.RELIGION()).getter.get(b.indu())).religion;
/* 157 */     return (ra != rb && this.map.get(ra.index()) && this.map.get(rb.index()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 164 */     this.map.save(file);
/* 165 */     file.d(this.timer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 170 */     this.map.load(file);
/* 171 */     this.timer = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 176 */     this.timer = -1.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizenRel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */