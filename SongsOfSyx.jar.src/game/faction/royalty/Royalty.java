/*     */ package game.faction.royalty;
/*     */ 
/*     */ import game.boosting.superb.SuperBoostableObj;
/*     */ import game.boosting.superb.SuperData;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import game.time.TIME;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import init.type.TRAIT;
/*     */ import init.type.TRAITS;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ public class Royalty
/*     */   implements SuperBoostableObj
/*     */ {
/*     */   public final Induvidual induvidual;
/*     */   public final NPCCourt court;
/*     */   final int deathDay;
/*     */   private boolean event;
/*     */   public short eventMark;
/*  30 */   private final SuperData bdata = ROPINION.BOOST().makeData();
/*     */   
/*  32 */   private static CharSequence ¤¤Ruler = "¤Ruler of {0}";
/*  33 */   private static CharSequence ¤¤Heir = "¤First Heir of {0}";
/*  34 */   private static CharSequence ¤¤Heir2 = "¤Second Heir of {0}";
/*  35 */   private static CharSequence ¤¤Heir3 = "¤Third Heir of {0}";
/*     */   static {
/*  37 */     D.ts(Royalty.class);
/*     */   }
/*  39 */   private final CharSequence[] sss = new CharSequence[] {
/*  40 */       ¤¤Ruler, 
/*  41 */       ¤¤Heir, 
/*  42 */       ¤¤Heir2, 
/*  43 */       ¤¤Heir3
/*     */     };
/*  45 */   public final ArrayListGrower<TRAIT> traits = new ArrayListGrower();
/*     */   
/*     */   Royalty(NPCCourt court, Race race) {
/*  48 */     this.induvidual = new Induvidual(HTYPES.NOBILITY(), race);
/*  49 */     this.court = court;
/*     */ 
/*     */     
/*  52 */     int ls = (STATS.POP()).age.lifespan(this.induvidual);
/*  53 */     int min = ls / 4;
/*  54 */     int dd = ls - 2 * min;
/*  55 */     int days = min + RND.rInt(dd);
/*  56 */     (STATS.POP()).age.DAYS.set(this.induvidual, days);
/*     */     
/*  58 */     this.deathDay = (int)((TIME.days().bitsSinceStart() + 1) + (ls - days) * RND.rFloat());
/*  59 */     setTitles();
/*     */   }
/*     */ 
/*     */   
/*     */   private void setTitles() {
/*  64 */     this.traits.clear();
/*  65 */     for (TRAIT t : TRAITS.tmp(this.induvidual, 3)) {
/*  66 */       if (this.traits.size() == 0 || Math.abs(t.get(this.induvidual) - 0.5D) > 0.2D) {
/*  67 */         this.traits.add(t);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   Royalty(NPCCourt court, FileGetter file) throws IOException {
/*  74 */     this.court = court;
/*  75 */     this.induvidual = new Induvidual(file);
/*  76 */     this.deathDay = file.i();
/*  77 */     this.bdata.load(file);
/*  78 */     this.event = file.bool();
/*  79 */     this.eventMark = file.s();
/*  80 */     setTitles();
/*     */   }
/*     */   
/*     */   public void update(double seconds) {
/*  84 */     ROPINION.BOOST().update(this, seconds);
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/*  88 */     this.induvidual.save(file);
/*  89 */     file.i(this.deathDay);
/*  90 */     this.bdata.save(file);
/*  91 */     file.bool(this.event);
/*  92 */     file.s(this.eventMark);
/*     */   }
/*     */   
/*     */   public void kill(boolean sendMessage) {
/*  96 */     this.court.kill(this);
/*     */   }
/*     */   
/*     */   public boolean isKing() {
/* 100 */     return (this.court.king().roy() == this);
/*     */   }
/*     */   
/*     */   public CharSequence name() {
/* 104 */     if (isKing())
/* 105 */       return (CharSequence)(this.court.king()).name; 
/* 106 */     return (STATS.APPEARANCE()).nameLast.name(this.induvidual);
/*     */   }
/*     */   
/*     */   public Str nameFull(Str s) {
/* 110 */     if (isKing()) {
/* 111 */       s.add((CharSequence)(this.court.king()).name);
/* 112 */       return (this.court.king()).name;
/*     */     } 
/* 114 */     s.add(STATS.APPEARANCE().name(this.induvidual));
/* 115 */     return s;
/*     */   }
/*     */   
/*     */   public Str nameSucc(Str s) {
/* 119 */     s.add(this.sss[successionI()]).insert(0, (CharSequence)this.court.faction.name);
/* 120 */     return s;
/*     */   }
/*     */   
/*     */   public int successionI() {
/* 124 */     return this.court.all.indexOf(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean event() {
/* 131 */     return this.event;
/*     */   }
/*     */   
/*     */   public void eventSet(boolean b) {
/* 135 */     this.event = b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SuperData boostingData() {
/* 141 */     return this.bdata;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\Royalty.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */