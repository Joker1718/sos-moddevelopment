/*     */ package game.events.slave;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.events.EVENTS;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.FResources;
/*     */ import game.time.TIME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.standing.STANDINGS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.ui.message.MessageText;
/*     */ 
/*     */ public final class EventUprising
/*     */   extends EVENTS.EventResource
/*     */ {
/*  34 */   private static CharSequence ¤¤warningA = "¤Slave Submission!";
/*  35 */   private static CharSequence ¤¤warningAD = "¤Slaves are acting a bit out of order lately and submission seems to be low. Perhaps it would be a good thing to free a few to raise their spirits.";
/*     */ 
/*     */   
/*  38 */   private static CharSequence ¤¤warning = "¤Slave Warning!";
/*  39 */   private static CharSequence ¤¤warningD = "¤Rumour has it that our wretched slaves feel mistreated. Some battlegear has also mysteriously gone missing. Might be a good time to deploy our troops close to the throne, just in case they think of something...";
/*     */   
/*  41 */   private static CharSequence ¤¤riot = "¤Slave Uprising!";
/*  42 */   private static CharSequence ¤¤riotD = "¤May the gods help us, the slaves are rising up to their masters! They claim to have had enough of your mistreatment and are now bent on ending your rule. Should they reach the throne, they will part with a good chunk of our riches and resources, and we shall be forever disgraced. Call in the troops and smite them, while there still is time!";
/*  43 */   private static CharSequence ¤¤amount = "¤{0} slaves have joined the uprising.";
/*  44 */   private static CharSequence ¤¤OverD = "¤The slave uprising has been defeated and your people rejoice at your might. Time to acquire new ones.";
/*  45 */   private static CharSequence ¤¤Over = "¤Uprising crushed!";
/*     */   
/*  47 */   private static CharSequence ¤¤LooseD = "¤The filthy slaves have captured the throne through low cunning. The wretches have plundered our stores and our treasury before deserting their master. May the gods help us through this calamity.";
/*  48 */   private static CharSequence ¤¤Loose = "¤Slaves triumph!";
/*     */ 
/*     */ 
/*     */   
/*  52 */   private final double updateD = 5.0D;
/*  53 */   private final double speed = 5.0D / (TIME.secondsPerDay() * 8);
/*     */   
/*  55 */   private double tt = 0.0D;
/*  56 */   private double acc = 0.0D;
/*     */   private int state;
/*     */   private int amountTotal;
/*  59 */   public final UprisingSpots spots = new UprisingSpots();
/*     */   
/*     */   static {
/*  62 */     D.ts(EventUprising.class);
/*     */   }
/*     */   
/*     */   public EventUprising() {
/*  66 */     super("SLAVES");
/*  67 */     IDebugPanelSett.add("Slave Uprising", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  71 */             EventUprising.this.riot();
/*     */           }
/*     */         });
/*     */     
/*  75 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  82 */     file.i(this.state);
/*  83 */     file.i(this.amountTotal);
/*  84 */     file.d(this.acc);
/*  85 */     this.spots.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  90 */     this.state = file.i();
/*  91 */     this.amountTotal = file.i();
/*  92 */     this.acc = file.d();
/*  93 */     this.spots.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/*  98 */     this.state = 0;
/*  99 */     this.amountTotal = 0;
/* 100 */     this.spots.clear();
/* 101 */     this.acc = 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 108 */     if (this.state == 0) {
/* 109 */       if (GAME.ARMIES().enemy().men() > 0)
/*     */         return; 
/* 111 */       if (STATS.POP().pop(HTYPES.SLAVE()) <= 0) {
/* 112 */         this.acc = 0.0D;
/*     */         return;
/*     */       } 
/* 115 */       this.tt -= ds;
/* 116 */       if (this.tt > 0.0D)
/*     */         return; 
/* 118 */       this.tt += 5.0D;
/*     */       
/* 120 */       double chance = Math.max(STANDINGS.SLAVE().current(), STANDINGS.SLAVE().target());
/* 121 */       chance = Math.max(0.0D, chance);
/* 122 */       if (chance >= 0.8D) {
/* 123 */         this.acc -= this.speed * (chance - 0.8D) / 0.2D;
/* 124 */         this.acc = CLAMP.d(this.acc, 0.0D, 1.0D);
/*     */         return;
/*     */       } 
/* 127 */       if (chance < 0.0D) {
/* 128 */         chance = 0.0D;
/*     */       }
/* 130 */       chance /= 0.8D;
/* 131 */       chance = 1.0D - chance;
/* 132 */       chance = Math.pow(chance, 0.5D);
/*     */       
/* 134 */       double old = this.acc;
/* 135 */       this.acc += this.speed * chance;
/*     */       
/* 137 */       if (this.acc > 1.0D) {
/* 138 */         this.acc = 0.0D;
/* 139 */         riot();
/* 140 */       } else if (old < 0.8D && this.acc > 0.8D) {
/* 141 */         (new MessageText(¤¤warningA, ¤¤warningAD)).send();
/*     */       }
/*     */     
/* 144 */     } else if (this.state == 1) {
/*     */       
/* 146 */       if (this.spots.update(ds)) {
/* 147 */         this.state = 2;
/* 148 */         Str t = Str.TMP;
/* 149 */         t.clear();
/* 150 */         t.add(¤¤amount).insert(0, this.amountTotal);
/* 151 */         this.acc = 0.0D;
/* 152 */         (new MessageText(¤¤riot, ¤¤riotD)).paragraph((CharSequence)t).send();
/*     */       }
/*     */     
/* 155 */     } else if (this.state == 2) {
/* 156 */       this.spots.update(ds);
/* 157 */       if (!this.spots.hasMore()) {
/* 158 */         this.state = 3;
/*     */       }
/* 160 */     } else if (this.state == 3) {
/*     */       int i, j;
/* 162 */       if (GAME.ARMIES().enemy().men() == 0) {
/* 163 */         ENTITY[] arrayOfENTITY; for (j = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, i = 0; i < j; ) { ENTITY e = arrayOfENTITY[i];
/* 164 */           if (e instanceof Humanoid) {
/* 165 */             Humanoid h = (Humanoid)e;
/* 166 */             if (h.indu().hType() == HTYPES.ENEMY())
/* 167 */               h.HTypeSet(HTYPES.SLAVE(), null, null); 
/*     */           } 
/*     */           i++; }
/*     */         
/* 171 */         (new MessageText(¤¤Over, ¤¤OverD)).send();
/* 172 */         this.state = 0;
/*     */         
/*     */         return;
/*     */       } 
/* 176 */       COORDINATE c = THRONE.coo();
/* 177 */       boolean enemy = false;
/* 178 */       boolean player = false;
/* 179 */       for (int x = c.x() - 3; x < c.x() + 3; x++) {
/* 180 */         for (int y = c.y() - 3; y < c.y() + 3; y++) {
/*     */           
/* 182 */           for (ENTITY e : SETT.ENTITIES().getAtTile(x, y)) {
/* 183 */             if (e instanceof Humanoid && (
/* 184 */               (Humanoid)e).indu().hType() == HTYPES.ENEMY() && ((Humanoid)e).division() != null) {
/* 185 */               if (((Humanoid)e).indu().hType() == HTYPES.ENEMY() && ((Humanoid)e).division() != null)
/* 186 */                 i = enemy | true; 
/* 187 */               if (((Humanoid)e).indu().clas() == HCLASSES.CITIZEN() && ((Humanoid)e).division() != null) {
/* 188 */                 j = player | true;
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 195 */       if (i != 0 && j == 0) {
/* 196 */         loose();
/*     */       }
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void loose() {
/* 210 */     this.acc = 0.0D;
/* 211 */     double am = 0.25D + 0.05D * RND.rInt(6);
/*     */     
/* 213 */     RESOURCE.remove(am, RBIT.ALL, FResources.RTYPE.SPOILS);
/*     */     
/* 215 */     int creds = (FACTIONS.player().credits().credits() > 0.0D) ? (int)(FACTIONS.player().credits().credits() * 0.75D) : 0;
/* 216 */     FACTIONS.player().credits().inc(-creds, FCredits.CTYPE.MISC);
/* 217 */     this.state = 0; byte b; int i;
/*     */     ENTITY[] arrayOfENTITY;
/* 219 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/* 220 */       if (e instanceof Humanoid) {
/* 221 */         Humanoid h = (Humanoid)e;
/* 222 */         if (h.indu().hType() == HTYPES.ENEMY())
/* 223 */           h.helloMyNameIsInigoMontoyaYouKilledMyFatherPrepareToDie(); 
/*     */       } 
/*     */       b++; }
/*     */     
/* 227 */     (new MessageText(¤¤Loose, ¤¤LooseD)).send();
/*     */   }
/*     */ 
/*     */   
/*     */   private void riot() {
/* 232 */     if (this.state != 0) {
/*     */       return;
/*     */     }
/*     */     
/* 236 */     double amd = 0.2D + RND.rFloat() * 0.8D;
/* 237 */     int am = this.spots.riot(amd);
/*     */     
/* 239 */     if (am == 0) {
/*     */       return;
/*     */     }
/* 242 */     this.amountTotal = am;
/* 243 */     this.state = 1;
/* 244 */     (new MessageText(¤¤warning, ¤¤warningD)).send();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\slave\EventUprising.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */