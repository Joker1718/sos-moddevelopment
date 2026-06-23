/*     */ package game.events.citizen;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.GUTIL;
/*     */ import util.text.D;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ final class EventCitizenRiot
/*     */   implements SAVABLE {
/*  33 */   private static CharSequence ¤¤riot = "¤Riot!";
/*  34 */   private static CharSequence ¤¤riotD = "¤Your subjects have had enough of you and your rule. They have risen up, determined to show their displeasure by murdering and vandalizing. The only way to quell these rebels is by calling in the military, set them to mopping up. Guards will also do their fair share. Riots will also subdue naturally without action in time.";
/*  35 */   private static CharSequence ¤¤amount = "¤We have reports of {0} rioters. The following species have joined: ";
/*  36 */   private static CharSequence ¤¤success = "¤The rioters have had a taste of your might and have laid down their arms. The ring leaders will be processed in your justice system and be made an example of.";
/*  37 */   private static CharSequence ¤¤Over = "¤Riot Over!";
/*  38 */   private static CharSequence ¤¤OverD = "¤The rioters have had enough of murdering and pillaging for now. They have returned to be law abiding citizens, until they feel it's time again.";
/*     */   
/*  40 */   private double timer = 0.0D;
/*     */   
/*     */   private double secondsToRiot;
/*  43 */   private int currentRioteers = 0;
/*     */   
/*     */   static {
/*  46 */     D.ts(EventCitizenRiot.class);
/*     */   }
/*     */ 
/*     */   
/*     */   EventCitizenRiot() {
/*  51 */     IDebugPanelSett.add("Event: Riot", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  55 */             int[] races = Alloc.ii(RACES.all().size());
/*  56 */             for (int i = 0; i < races.length; i++) {
/*  57 */               races[i] = (int)Math.ceil(((STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(RACES.all().get(i)) * RND.rExpo()));
/*     */             }
/*  59 */             EventCitizenRiot.this.riot(races);
/*     */           }
/*     */         });
/*     */     
/*  63 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  69 */     file.d(this.timer);
/*  70 */     file.d(this.secondsToRiot);
/*  71 */     file.i(this.currentRioteers);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  76 */     this.timer = file.d();
/*  77 */     this.secondsToRiot = file.d();
/*  78 */     this.currentRioteers = file.i();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  83 */     this.timer = 0.0D;
/*  84 */     this.secondsToRiot = 0.0D;
/*  85 */     this.currentRioteers = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double ds) {
/*  90 */     this.timer += ds;
/*  91 */     if (this.timer < 10.0D)
/*     */       return; 
/*  93 */     this.timer -= 10.0D;
/*     */ 
/*     */ 
/*     */     
/*  97 */     if (STATS.POP().pop(HTYPES.RIOTER()) > 0) {
/*  98 */       if (STATS.POP().pop(HTYPES.RIOTER()) / this.currentRioteers < 0.3D) {
/*  99 */         byte b; int i; ENTITY[] arrayOfENTITY; for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 100 */           if (e instanceof Humanoid) {
/* 101 */             Humanoid a = (Humanoid)e;
/* 102 */             if (a.indu().hType() == HTYPES.RIOTER())
/* 103 */               a.HTypeSet(RND.oneIn(5) ? HTYPES.PRISONER() : HTYPES.SUBJECT(), CAUSE_LEAVES.PUNISHED(), null); 
/*     */           } 
/*     */           b++; }
/*     */         
/* 107 */         (new MessageText(¤¤Over, ¤¤success)).send();
/*     */       } 
/*     */       
/* 110 */       this.secondsToRiot -= 10.0D;
/* 111 */       if (this.secondsToRiot <= 0.0D) {
/* 112 */         byte b; int i; ENTITY[] arrayOfENTITY; for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 113 */           if (e instanceof Humanoid) {
/* 114 */             Humanoid a = (Humanoid)e;
/* 115 */             if (a.indu().hType() == HTYPES.RIOTER())
/* 116 */               a.HTypeSet(HTYPES.SUBJECT(), null, null); 
/*     */           } 
/*     */           b++; }
/*     */         
/* 120 */         (new MessageText(¤¤Over, ¤¤OverD)).send();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void riot(int[] races) {
/* 131 */     this.currentRioteers = 0;
/*     */ 
/*     */     
/* 134 */     this.secondsToRiot = TIME.secondsPerDay() * 0.25D + (RND.rFloat() * TIME.secondsPerDay()) * 0.75D;
/* 135 */     int[] tot = Alloc.ii(RACES.all().size());
/*     */ 
/*     */     
/* 138 */     for (int i = 0; i < races.length; i++) {
/* 139 */       tot[i] = races[i];
/*     */     }
/*     */     
/* 142 */     Humanoid first = null; byte b; int j;
/*     */     ENTITY[] arrayOfENTITY;
/* 144 */     for (j = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < j; ) { ENTITY e = arrayOfENTITY[b];
/* 145 */       if (e instanceof Humanoid) {
/* 146 */         Humanoid a = (Humanoid)e;
/* 147 */         if (a.indu().hType() == HTYPES.SUBJECT() && races[(a.race()).index] > 0) {
/* 148 */           first = a;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */     
/* 154 */     if (first == null) {
/*     */       return;
/*     */     }
/* 157 */     GUTIL.flooder().init(this);
/* 158 */     GUTIL.flooder().pushSloppy(first.tc(), 0.0D);
/* 159 */     while (GUTIL.flooder().hasMore()) {
/* 160 */       PathTile c = GUTIL.flooder().pollSmallest();
/* 161 */       for (ENTITY e : SETT.ENTITIES().getAtTile(c.x(), c.y())) {
/* 162 */         if (e instanceof Humanoid) {
/* 163 */           Humanoid a = (Humanoid)e;
/* 164 */           if (a.indu().hType() == HTYPES.SUBJECT() && races[(a.race()).index] > 0) {
/* 165 */             races[(a.race()).index] = races[(a.race()).index] - 1;
/* 166 */             this.currentRioteers++;
/* 167 */             a.HTypeSet(HTYPES.RIOTER(), null, null);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 172 */       for (DIR d : DIR.ALL) {
/* 173 */         if (!(SETT.PATH()).solidity.is((COORDINATE)c, d) && SETT.IN_BOUNDS((COORDINATE)c, d))
/* 174 */           GUTIL.flooder().pushSmaller((COORDINATE)c, d, c.getValue() + d.tileDistance()); 
/*     */       } 
/*     */     } 
/* 177 */     GUTIL.flooder().done();
/*     */ 
/*     */     
/* 180 */     if (this.currentRioteers > 0) {
/* 181 */       STANDINGS.emergency(HCLASSES.CITIZEN(), (TIME.secondsPerDay() * 4));
/* 182 */       Str t = Str.TMP;
/* 183 */       t.clear();
/*     */       
/* 185 */       t.add(¤¤amount).insert(0, this.currentRioteers);
/* 186 */       t.NL();
/* 187 */       for (Race r : RACES.all()) {
/* 188 */         if (tot[r.index] - races[r.index] > 0) {
/* 189 */           t.NL();
/* 190 */           t.add(r.info.names);
/*     */         } 
/*     */       } 
/*     */       
/* 194 */       (new MessageText(¤¤riot, ¤¤riotD)).paragraph((CharSequence)t).send();
/*     */       
/* 196 */       (GAME.count()).RIOTS.inc(1);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\citizen\EventCitizenRiot.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */