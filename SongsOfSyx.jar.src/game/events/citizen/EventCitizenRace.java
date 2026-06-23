/*     */ package game.events.citizen;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StrInserter;
/*     */ import util.text.D;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ final class EventCitizenRace
/*     */   implements EventCitizen.SMALL_EVENT
/*     */ {
/*  24 */   private static CharSequence ¤¤title = "Brawls!";
/*  25 */   private static CharSequence ¤¤desc = "A local dispute between a {RACE_A} and {RACE_B} citizen has spread across the whole city. The two species are now at each others throats and fighting each other wherever they meet. We must fix our happiness issues before this spreads any further.";
/*     */   
/*  27 */   private final StrInserter<Race> iA = new StrInserter<Race>("RACE_A")
/*     */     {
/*     */       protected void set(Race t, Str str)
/*     */       {
/*  31 */         str.add(t.info.namePosessive);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  36 */   private final StrInserter<Race> iB = new StrInserter<Race>("RACE_B")
/*     */     {
/*     */       protected void set(Race t, Str str)
/*     */       {
/*  40 */         str.add(t.info.namePosessive);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   private int ra;
/*     */   
/*     */   private int rb;
/*     */   
/*     */   private double timer;
/*     */   
/*     */   static {
/*  52 */     D.ts(EventCitizenRace.class);
/*     */   }
/*     */ 
/*     */   
/*     */   EventCitizenRace() {
/*  57 */     IDebugPanelSett.add("Event: race war", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  61 */             EventCitizenRace.this.event(100, FACTIONS.player().race());
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
/*     */   
/*     */   public boolean event(int am, Race race) {
/*  76 */     this.ra = -1;
/*  77 */     this.rb = -1;
/*     */     
/*  79 */     return spawnRace(race);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean spawnRace(Race race) {
/*  84 */     double max = 0.0D; int ri;
/*  85 */     for (ri = 0; ri < RACES.all().size(); ri++) {
/*  86 */       Race r = (Race)RACES.all().get(ri);
/*  87 */       if ((STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(r) > 0 && race != r && race.pref().race(r) < 1.0D) {
/*  88 */         max += (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(r) * (1.0D - race.pref().race(r));
/*     */       }
/*     */     } 
/*  91 */     if (max == 0.0D) {
/*  92 */       return false;
/*     */     }
/*  94 */     max *= RND.rFloat();
/*     */     
/*  96 */     for (ri = 0; ri < RACES.all().size(); ri++) {
/*  97 */       Race r = (Race)RACES.all().get(ri);
/*  98 */       if ((STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(r) > 0 && race != r && race.pref().race(r) < 1.0D) {
/*  99 */         max -= (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(r) * (1.0D - race.pref().race(r));
/* 100 */         if (max <= 0.0D) {
/* 101 */           this.timer = (TIME.secondsPerDay() * (1.0F + RND.rFloat(2.0D)));
/* 102 */           this.ra = race.index;
/* 103 */           this.rb = r.index;
/* 104 */           Str s = new Str(¤¤desc);
/* 105 */           this.iA.insert(race, s);
/* 106 */           this.iB.insert(r, s);
/* 107 */           (new MessageText(¤¤title, (CharSequence)s)).send();
/*     */         } 
/*     */       } 
/*     */     } 
/* 111 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAtOdds(Humanoid a, Humanoid b) {
/* 117 */     if (this.timer <= 0.0D)
/* 118 */       return false; 
/* 119 */     if (this.ra != -1) {
/* 120 */       return !(((a.race()).index != this.ra || (b.race()).index != this.rb) && ((a.race()).index != this.rb || (b.race()).index != this.ra));
/*     */     }
/* 122 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 129 */     file.i(this.ra);
/* 130 */     file.i(this.rb);
/* 131 */     file.d(this.timer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 136 */     this.ra = file.i();
/* 137 */     this.rb = file.i();
/* 138 */     this.timer = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 143 */     this.timer = -1.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizenRace.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */