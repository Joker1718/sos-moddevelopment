/*     */ package game.events.citizen;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import init.type.WGROUP;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmployment;
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
/*     */ final class EventCitizenStrike
/*     */   implements EventCitizen.SMALL_EVENT {
/*  26 */   private static CharSequence ¤¤strike = "¤Worker Strike!";
/*  27 */   private static CharSequence ¤¤strikeD = "¤Your {RACE} workers have halted all work in our {WORKPLACES}, in protest of what they call your bad judgement. Take measures to increase their loyalty so that it doesn't happen again.";
/*  28 */   private static CharSequence ¤¤strikeOver = "¤Strike Over";
/*  29 */   private static CharSequence ¤¤strikeOverD = "¤Your {WORKPLACES} have resumed work and the strike is over.";
/*     */   
/*  31 */   private RoomEmployment strike = null;
/*  32 */   private double strikeTimer = 0.0D;
/*  33 */   private StrInserter<Race> iRace = new StrInserter<Race>("RACE")
/*     */     {
/*     */       public void set(Race t, Str str) {
/*  36 */         str.add(t.info.namePosessive);
/*     */       }
/*     */     };
/*     */   
/*  40 */   private StrInserter<RoomEmployment> iWork = new StrInserter<RoomEmployment>("WORKPLACES")
/*     */     {
/*     */       public void set(RoomEmployment t, Str str) {
/*  43 */         str.add((t.blueprint()).info.names);
/*     */       }
/*     */     };
/*     */   
/*     */   static {
/*  48 */     D.ts(EventCitizenStrike.class);
/*     */   }
/*     */   
/*     */   public EventCitizenStrike() {
/*  52 */     IDebugPanelSett.add("Event: Strike", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  56 */             int ri = RND.rInt(RACES.all().size());
/*  57 */             for (int i = 0; i < RACES.all().size(); i++) {
/*  58 */               Race r = (Race)RACES.all().getC(ri + i);
/*  59 */               if (EventCitizenStrike.this.event(0, r)) {
/*     */                 return;
/*     */               }
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void save(FilePutter file) {
/*  68 */     file.i((this.strike == null) ? -1 : this.strike.index());
/*  69 */     file.d(this.strikeTimer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  74 */     int i = file.i();
/*  75 */     if (i == -1) {
/*  76 */       this.strike = null;
/*     */     } else {
/*  78 */       this.strike = (RoomEmployment)(SETT.ROOMS()).employment.ALL().get(i);
/*  79 */     }  this.strikeTimer = file.d();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  85 */     this.strikeTimer = 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean event(int am, Race hr) {
/*  91 */     RoomEmployment strike = null;
/*  92 */     int most = 0;
/*  93 */     for (RoomEmployment e : (SETT.ROOMS()).employment.ALL()) {
/*  94 */       if (e.employed(WGROUP.get(HTYPES.SUBJECT(), hr)) > most) {
/*  95 */         strike = e;
/*  96 */         most = e.employed(WGROUP.get(HTYPES.SUBJECT(), hr));
/*     */       } 
/*     */     } 
/*     */     
/* 100 */     if (strike == null) {
/* 101 */       return false;
/*     */     }
/* 103 */     this.strike = strike;
/* 104 */     this.strikeTimer = TIME.secondsPerDay() * 1.5D;
/*     */     
/* 106 */     Str s = Str.TMP.clear();
/* 107 */     s.add(¤¤strikeD);
/* 108 */     this.iRace.insert(hr, s);
/* 109 */     this.iWork.insert(strike, s);
/* 110 */     (new MessageText(¤¤strike, (CharSequence)s)).send();
/*     */     
/* 112 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/* 118 */     if (this.strikeTimer <= 0.0D) {
/*     */       return;
/*     */     }
/* 121 */     this.strikeTimer -= ds;
/* 122 */     if (this.strikeTimer <= 0.0D) {
/* 123 */       Str s = Str.TMP.clear();
/* 124 */       s.add(¤¤strikeOverD);
/* 125 */       this.iWork.insert(this.strike, s);
/* 126 */       (new MessageText(¤¤strikeOver, (CharSequence)s)).send();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isStriking(Humanoid h) {
/* 132 */     return (this.strikeTimer > 0.0D && (STATS.WORK()).EMPLOYED.get(h) != null && ((RoomInstance)(STATS.WORK()).EMPLOYED.get(h)).blueprintI().employment() == this.strike);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizenStrike.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */