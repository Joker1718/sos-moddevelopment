/*     */ package game.events.citizen;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.Alloc;
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
/*     */ final class EventCitizenEmmigrate
/*     */   implements EventCitizen.SMALL_EVENT
/*     */ {
/*  25 */   private static CharSequence ¤¤emigration = "¤Mass Emigrantion!";
/*  26 */   private static CharSequence ¤¤emigrationD = "¤A large group of {RACE} have decided to leave your city, renouncing their citizenship, and your rule. This is a sign of weakness. Make sure you increase loyalty so that this will not happen again!";
/*  27 */   private static StrInserter<Race> iRace = new StrInserter<Race>("RACE")
/*     */     {
/*     */       public void set(Race t, Str str) {
/*  30 */         str.add(t.info.names);
/*     */       }
/*     */     };
/*     */   static {
/*  34 */     D.ts(EventCitizenEmmigrate.class);
/*     */   }
/*     */   
/*  37 */   private final int[] emmigrations = Alloc.ii(RACES.all().size());
/*     */   
/*     */   public EventCitizenEmmigrate() {
/*  40 */     IDebugPanelSett.add("Event: Emmigration", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  44 */             int ri = RND.rInt(RACES.all().size());
/*  45 */             for (int i = 0; i < RACES.all().size(); i++) {
/*  46 */               Race r = (Race)RACES.all().getC(ri + i);
/*  47 */               int am = (int)Math.ceil(((STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(r) * RND.rFloat()));
/*  48 */               if (am > 0) {
/*  49 */                 EventCitizenEmmigrate.this.event(am, r);
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  59 */     file.isE(this.emmigrations);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  64 */     file.isE(this.emmigrations);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  69 */     Arrays.fill(this.emmigrations, 0);
/*     */   }
/*     */   
/*     */   public boolean shouldEmigrate(Race r) {
/*  73 */     if ((STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(r) == 0) {
/*  74 */       this.emmigrations[r.index()] = 0;
/*  75 */       return false;
/*     */     } 
/*  77 */     return (this.emmigrations[r.index()] > 0);
/*     */   }
/*     */   
/*     */   public void emigrate(Humanoid h) {
/*  81 */     this.emmigrations[h.race().index()] = this.emmigrations[h.race().index()] - 1;
/*  82 */     if (this.emmigrations[(h.race()).index] < 0) {
/*  83 */       this.emmigrations[(h.race()).index] = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(int amH, Race hr) {
/*  89 */     if (SETT.ENTRY().isClosed()) {
/*  90 */       return false;
/*     */     }
/*  92 */     this.emmigrations[hr.index] = amH;
/*     */     
/*  94 */     Str t = Str.TMP;
/*  95 */     t.clear();
/*  96 */     t.add(¤¤emigrationD);
/*  97 */     iRace.insert(hr, t);
/*  98 */     (new MessageText(¤¤emigration, (CharSequence)t)).send();
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   void inc(int amH, Race hr) {
/* 103 */     this.emmigrations[hr.index] = this.emmigrations[hr.index] + amH;
/*     */   }
/*     */   
/*     */   public void update(double ds) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizenEmmigrate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */