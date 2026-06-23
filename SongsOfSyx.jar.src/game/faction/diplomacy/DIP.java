/*     */ package game.faction.diplomacy;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.FactionResource;
/*     */ import game.faction.diplomacy.deal.Deal;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Bitsmap2D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.Debugger;
/*     */ import util.text.D;
/*     */ import view.interrupter.IDebugPanel;
/*     */ 
/*     */ public final class DIP extends FactionResource {
/*     */   static DIP s;
/*  33 */   private final ArrayListGrower<DipStance> all = new ArrayListGrower();
/*     */   
/*     */   public final DipStance neutral;
/*     */   public final DWar enemies;
/*     */   public final DipStance traders;
/*     */   public final DipStance pact;
/*     */   public final DipStance allied;
/*     */   public final DipStance vassal;
/*     */   public final DipStance overlord;
/*  42 */   public final DipWarPlayer warPlayer = new DipWarPlayer();
/*     */   
/*  44 */   private final UpVassal uv = new UpVassal();
/*     */   
/*     */   private final Deal dealTmp;
/*  47 */   private final Bitsmap2D data = new Bitsmap2D(0, 4, FACTIONS.MAX(), FACTIONS.MAX());
/*  48 */   private final int[] overlords = Alloc.ii(FACTIONS.MAX());
/*     */   
/*  50 */   private final int[] secondOfStance = Alloc.ii(FACTIONS.MAX() * FACTIONS.MAX());
/*  51 */   public double playerWarSecond = -1.0D;
/*     */   
/*  53 */   int stateI = -1; private final ArrayList<FactionNPC> tmp;
/*     */   private int ffi;
/*     */   
/*     */   protected void save(FilePutter file) {
/*  57 */     this.data.save(file);
/*  58 */     this.uv.save(file);
/*  59 */     file.isE(this.overlords);
/*  60 */     file.is(this.secondOfStance);
/*  61 */     file.d(this.playerWarSecond);
/*  62 */     this.warPlayer.teamName.save(file);
/*  63 */     this.warPlayer.warName.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  68 */     this.data.load(file);
/*  69 */     this.uv.load(file);
/*  70 */     file.isE(this.overlords);
/*  71 */     file.is(this.secondOfStance);
/*  72 */     this.playerWarSecond = file.d();
/*  73 */     this.stateI = -1;
/*  74 */     this.warPlayer.teamName.load(file);
/*  75 */     this.warPlayer.warName.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/*  80 */     this.data.clear();
/*  81 */     this.uv.clear();
/*  82 */     Arrays.fill(this.secondOfStance, 0);
/*  83 */     Arrays.fill(this.overlords, 0);
/*  84 */     this.stateI = -1;
/*  85 */     this.playerWarSecond = -1.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DipStance get(Faction faction, Faction other) {
/* 157 */     return (DipStance)s.all.get(s.data.get(faction.index(), other.index()));
/*     */   }
/*     */   
/*     */   public static DipStance get(FactionNPC faction) {
/* 161 */     return (DipStance)s.all.get(s.data.get(faction.index(), FACTIONS.player().index()));
/*     */   }
/*     */   
/*     */   public static double secondSinceStance(Faction a, Faction b) {
/* 165 */     if (a.index() < b.index()) {
/* 166 */       Faction c = a;
/* 167 */       a = b;
/* 168 */       b = c;
/*     */     } 
/* 170 */     return TIME.playedGame() - s.secondOfStance[a.index() * FACTIONS.MAX() + b.index()];
/*     */   }
/*     */   
/*     */   public static void secondSincestartInc(Faction a, Faction b, double d) {
/* 174 */     if (a.index() < b.index()) {
/* 175 */       Faction c = a;
/* 176 */       a = b;
/* 177 */       b = c;
/*     */     } 
/* 179 */     s.secondOfStance[a.index() * FACTIONS.MAX() + b.index()] = (int)(s.secondOfStance[a.index() * FACTIONS.MAX() + b.index()] + d * 16.0D * 8.0D * TIME.secondsPerDay());
/*     */   }
/*     */   
/*     */   public static double secondSinceStance(FactionNPC f) {
/* 183 */     return secondSinceStance((Faction)FACTIONS.player(), (Faction)f);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double secondsOFPlayerWar() {
/* 195 */     if (s.playerWarSecond < 0.0D)
/* 196 */       return 0.0D; 
/* 197 */     return TIME.currentSecond() - s.playerWarSecond;
/*     */   }
/*     */   
/*     */   public static Faction overlord(Faction f) {
/* 201 */     int i = s.overlords[f.index()];
/* 202 */     if (i > 0) {
/* 203 */       return FACTIONS.getByIndex(i - 1);
/*     */     }
/* 205 */     return null;
/*     */   }
/*     */   
/*     */   private void clear(Faction f) {
/* 209 */     for (int i = 0; i < FACTIONS.MAX(); i++) {
/* 210 */       this.data.set(f.index(), i, 0);
/* 211 */       this.data.set(i, f.index(), 0);
/* 212 */       if (this.overlords[i] == f.index() + 1) {
/* 213 */         this.overlords[i] = 0;
/*     */       }
/*     */     } 
/* 216 */     this.overlords[f.index()] = 0;
/*     */     
/* 218 */     this.stateI++;
/*     */   }
/*     */ 
/*     */   
/*     */   private void clearAllButTrade(Faction f) {
/* 223 */     for (int i = 0; i < FACTIONS.MAX(); i++) {
/* 224 */       if (i != f.index() && (get(f, FACTIONS.getByIndex(i))).trades) {
/* 225 */         this.data.set(f.index(), i, TRADE().index());
/* 226 */         this.data.set(i, f.index(), TRADE().index());
/*     */       } else {
/* 228 */         this.data.set(f.index(), i, 0);
/* 229 */         this.data.set(i, f.index(), 0);
/*     */       } 
/*     */       
/* 232 */       if (this.overlords[i] == f.index() + 1)
/* 233 */         this.overlords[i] = 0; 
/*     */     } 
/* 235 */     this.overlords[f.index()] = 0;
/*     */     
/* 237 */     this.stateI++;
/*     */   }
/*     */ 
/*     */   
/*     */   void set(Faction instigator, Faction accepter, DipStance dip) {
/* 242 */     DipStance old = get(instigator, accepter);
/* 243 */     if (old == dip) {
/*     */       return;
/*     */     }
/* 246 */     boolean pemeny = this.enemies.any((Faction)FACTIONS.player());
/*     */ 
/*     */     
/* 249 */     this.stateI++;
/*     */     
/* 251 */     Faction a = instigator;
/* 252 */     Faction b = accepter;
/* 253 */     Faction c = a;
/* 254 */     a = b;
/* 255 */     b = c;
/* 256 */     s.secondOfStance[a.index() * FACTIONS.MAX() + b.index()] = (int)TIME.playedGame();
/*     */ 
/*     */     
/* 259 */     if (dip == VASSAL()) {
/* 260 */       clearAllButTrade(instigator);
/*     */       
/* 262 */       this.overlords[instigator.index()] = accepter.index() + 1;
/*     */       
/* 264 */       this.data.set(instigator.index(), accepter.index(), VASSAL().index());
/* 265 */       this.data.set(accepter.index(), instigator.index(), OVERLORD().index());
/*     */     }
/* 267 */     else if (dip == OVERLORD()) {
/* 268 */       clearAllButTrade(accepter);
/* 269 */       this.overlords[accepter.index()] = instigator.index() + 1;
/*     */       
/* 271 */       this.data.set(instigator.index(), accepter.index(), OVERLORD().index());
/* 272 */       this.data.set(accepter.index(), instigator.index(), VASSAL().index());
/*     */     } else {
/*     */       
/* 275 */       if (overlord(accepter) == instigator)
/* 276 */         this.overlords[accepter.index()] = 0; 
/* 277 */       if (overlord(instigator) == accepter)
/* 278 */         this.overlords[instigator.index()] = 0; 
/* 279 */       this.data.set(instigator.index(), accepter.index(), dip.index());
/* 280 */       this.data.set(accepter.index(), instigator.index(), dip.index());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 290 */     for (DipActivityListener li : DipActivityListener.all) {
/* 291 */       li.change(instigator, accepter, old, dip);
/*     */     }
/*     */     
/* 294 */     ally(accepter, old);
/* 295 */     ally(instigator, old);
/*     */     
/* 297 */     if (!this.enemies.any((Faction)FACTIONS.player())) {
/* 298 */       this.playerWarSecond = -1.0D;
/* 299 */     } else if (!pemeny) {
/* 300 */       this.playerWarSecond = TIME.currentSecond();
/*     */     } 
/*     */     
/* 303 */     this.stateI++;
/*     */   }
/*     */   private void ally(Faction f, DipStance old) {
/*     */     int ai;
/* 307 */     for (ai = 0; ai < FACTIONS.MAX(); ai++) {
/* 308 */       Faction f2 = (Faction)FACTIONS.all().get(ai);
/*     */       
/* 310 */       if ((get(f2, f)).ally) {
/* 311 */         for (int ei = 0; ei < FACTIONS.MAX(); ei++) {
/* 312 */           Faction f3 = (Faction)FACTIONS.all().get(ei);
/* 313 */           if (get(f, f3) == this.enemies || get(f2, f2) == this.enemies) {
/* 314 */             set(f, f3, this.enemies);
/* 315 */             set(f2, f3, this.enemies);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 321 */     if (f == FACTIONS.player() && old == this.enemies)
/*     */     {
/* 323 */       for (ai = 0; ai < FACTIONS.MAX(); ai++) {
/* 324 */         Faction f2 = (Faction)FACTIONS.all().get(ai);
/*     */         
/* 326 */         if ((get(f2, f)).ally) {
/* 327 */           for (int ei = 0; ei < FACTIONS.MAX(); ei++) {
/* 328 */             Faction f3 = (Faction)FACTIONS.all().get(ei);
/* 329 */             if (get(f2, f3) == this.enemies && get(f, f3) != this.enemies) {
/* 330 */               set(f, f3, this.neutral);
/* 331 */               set(f2, f3, this.neutral);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean is(Faction a, Faction b, DipStance dip) {
/* 342 */     if (dip == this.overlord)
/* 343 */       return (overlord(b) == a); 
/* 344 */     if (dip == this.vassal) {
/* 345 */       return (overlord(a) == b);
/*     */     }
/* 347 */     return (this.all.get(this.data.get(a.index(), b.index())) == dip);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Faction f) {
/* 354 */     this.uv.update();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static DipStance NEUTRAL() {
/* 360 */     return s.neutral;
/*     */   }
/*     */   
/*     */   public static DWar WAR() {
/* 364 */     return s.enemies;
/*     */   }
/*     */   
/*     */   public static DipStance TRADE() {
/* 368 */     return s.traders;
/*     */   }
/*     */   
/*     */   public static Deal TMP() {
/* 372 */     return s.dealTmp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DipStance ALLY() {
/* 380 */     return s.allied;
/*     */   }
/*     */   
/*     */   public static DipStance PACT() {
/* 384 */     return s.pact;
/*     */   }
/*     */   
/*     */   public static DipStance VASSAL() {
/* 388 */     return s.vassal;
/*     */   }
/*     */   
/*     */   public static DipStance OVERLORD() {
/* 392 */     return s.overlord;
/*     */   }
/*     */   
/*     */   public static DipWarPlayer WAR_PLAYER() {
/* 396 */     return s.warPlayer;
/*     */   }
/*     */   
/*     */   public static abstract class DipActivityListener
/*     */   {
/* 401 */     static final LinkedList<DipActivityListener> all = new LinkedList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DipActivityListener() {
/* 413 */       all.add(this);
/*     */     }
/*     */     
/*     */     public abstract void change(Faction param1Faction1, Faction param1Faction2, DipStance param1DipStance1, DipStance param1DipStance2);
/*     */   }
/*     */   
/*     */   public DIP(FACTIONS ff) {
/* 420 */     this.tmp = new ArrayList(FACTIONS.MAX());
/* 421 */     this.ffi = -1; s = this; D.gInit(this); double tarif = 0.25D; this.neutral = new DipStance((LISTE<DipStance>)this.all, "NEUTRAL", 0.0D, 0.0D, tarif, false, false, false, D.g("NEUTRAL", "Neutral"), D.g("NEUTRALD", "No relations at all"), (SPRITE)(UI.icons()).s.flag); this.enemies = new DWar((LISTE<DipStance>)this.all); this.traders = new DipStance((LISTE<DipStance>)this.all, "TRADE", 0.1D, 1.5D, tarif * 0.8D, true, false, false, D.g("TRADE", "Trade Partners"), D.g("TRADED", "Trade partners can exchange goods automatically at favourable rates. Requires 1 in opinion to be considered."), (SPRITE)(UI.icons()).s.trade.createColored((COLOR)new ColorImp(128, 128, 20))); this.pact = new DipStance((LISTE<DipStance>)this.all, "PACT", 0.4D, 2.5D, tarif * 0.6D, true, true, false, D.g("PACT", "Colleagues"), D.g("PACTD", "A colleague not only trades at a discounted rate, but allow transit through their lands. Requires 2.5 in opinion to be considered."), (SPRITE)(UI.icons()).s.flag.createColored((COLOR)new ColorImp(90, 128, 90))); this.allied = new DipStance((LISTE<DipStance>)this.all, "ALLIED", 1.0D, 6.0D, tarif * 0.4D, true, true, true, D.g("ALLY", "Allies"), D.g("ALLYD", "An ally is your sworn bannerman. You share the same enemies, trade and swear to never question each other's rule. Requires 6 in opinion to be considered."), (SPRITE)(UI.icons()).s.shield.createColored((COLOR)new ColorImp(90, 128, 128))); this.vassal = new DipStance((LISTE<DipStance>)this.all, "VASSAL", 1.0D, 6.0D, tarif * 0.4D, true, true, true, D.g("VASSAL", "Vassal"), D.g("VASSALD", "A Vassal serves its overlord with tribute. In return, they are protected."), (SPRITE)(UI.icons()).s.slave.createColored((COLOR)new ColorImp(90, 128, 90))); this.overlord = new DipStance((LISTE)this.all, "OVERLORD", 1.0D, 6.0D, tarif * 0.4D, true, true, true, D.g("PROTECTOR", "Protector"), D.g("PROTECTORD", "A Protector is the overlord of a vassal. Their task is to protect, and in return they get to enjoy some tribute at the end of each year."), (SPRITE)(UI.icons()).s.noble.createColored((COLOR)new ColorImp(128, 20, 128))) {  }; IDebugPanel.add("Total War", new ACTION() { public void exe() { for (FactionNPC f : FACTIONS.NPCs())
/*     */               DIP.this.enemies.set(f);  } }); this.dealTmp = new Deal();
/* 423 */   } private static final ACTION increase = new ACTION()
/*     */     {
/*     */       public void exe()
/*     */       {
/* 427 */         for (int fi = 0; fi < FACTIONS.MAX(); fi++)
/* 428 */           DIP.s.secondOfStance[fi * FACTIONS.MAX() + FACTIONS.player().index()] = DIP.s.secondOfStance[fi * FACTIONS.MAX() + FACTIONS.player().index()] - TIME.secondsPerDay(); 
/*     */       }
/*     */     };
/*     */   
/*     */   public static LIST<FactionNPC> traders() {
/* 433 */     if (GAME.updateI() == s.ffi) {
/* 434 */       return (LIST<FactionNPC>)s.tmp;
/*     */     }
/* 436 */     s.ffi = GAME.updateI();
/* 437 */     s.tmp.clearSloppy();
/* 438 */     for (FactionNPC f : FACTIONS.NPCs()) {
/* 439 */       if (f.isActive() && (get(f)).trades) {
/* 440 */         s.tmp.add(f);
/*     */       }
/*     */     } 
/* 443 */     return (LIST<FactionNPC>)s.tmp;
/*     */   }
/*     */   
/*     */   public static void debug(Debugger d, FactionNPC f) {
/* 447 */     d.title(DIP.class.getSimpleName());
/*     */     
/* 449 */     d.debug("stance").add((get(f)).name);
/* 450 */     d.debug("since Days").add(secondSinceStance(f) * TIME.secondsPerDayI());
/* 451 */     d.debug("increase time", increase);
/* 452 */     d.debug("war days").add(s.playerWarSecond * TIME.secondsPerDayI());
/* 453 */     s.warPlayer.debug(d, f);
/* 454 */     s.warPlayer.debug(d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\DIP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */