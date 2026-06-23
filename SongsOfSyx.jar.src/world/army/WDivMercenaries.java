/*     */ package world.army;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FCredits;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.time.TIME;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import util.updating.IUpdater;
/*     */ import view.ui.message.MessageText;
/*     */ import view.world.panel.IDebugPanelWorld;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ public final class WDivMercenaries
/*     */   implements LIST<WDivMercenary>
/*     */ {
/*  27 */   private ArrayList<WDivMercenary> all = new ArrayList(40);
/*     */   
/*  29 */   private static CharSequence ¤¤mWTitle = "¤Mercenaries Displeased!";
/*  30 */   private static CharSequence ¤¤mWBody = "¤We are running low on Denari and can't pay our mercenaries. We need at least {0} additional Denari to ensure their loyalty.";
/*     */   
/*  32 */   private static CharSequence ¤¤mTitle = "¤Mercenaries leaving!";
/*  33 */   private static CharSequence ¤¤mBody = "¤Since you don't have enough credits to pay them, your hired mercenaries are leaving you.";
/*     */   
/*     */   static {
/*  36 */     D.ts(WDivMercenaries.class);
/*     */   }
/*     */   
/*  39 */   private final IUpdater updater = new IUpdater(this.all.max(), TIME.secondsPerDay())
/*     */     {
/*     */       protected void update(int di, double timeSinceLast)
/*     */       {
/*  43 */         if (di == 10) {
/*  44 */           int missed = 0;
/*  45 */           int cc = 0;
/*  46 */           for (WDivMercenary wDivMercenary : WDivMercenaries.this.all) {
/*  47 */             if (wDivMercenary.army() == null || wDivMercenary.army().faction() != FACTIONS.player())
/*     */               continue; 
/*  49 */             if (wDivMercenary.missedPayments < 0) {
/*  50 */               wDivMercenary.missedPayments = 0;
/*     */               continue;
/*     */             } 
/*  53 */             int cost = (int)((wDivMercenary.costPerMan() * wDivMercenary.men()) * wDivMercenary.army().supplyAmount());
/*  54 */             if (cost > FACTIONS.player().credits().credits()) {
/*  55 */               wDivMercenary.missedPayments = (byte)(wDivMercenary.missedPayments + 1);
/*  56 */               if (wDivMercenary.missedPayments >= 2) {
/*  57 */                 wDivMercenary.reassign(null);
/*     */               }
/*  59 */               cc += cost;
/*  60 */               missed = Math.max(missed, wDivMercenary.missedPayments); continue;
/*     */             } 
/*  62 */             FACTIONS.player().credits().inc(-cost, FCredits.CTYPE.MERCINARIES);
/*  63 */             wDivMercenary.missedPayments = (byte)(wDivMercenary.missedPayments - 1);
/*  64 */             if (wDivMercenary.missedPayments > 0 && cost <= FACTIONS.player().credits().credits()) {
/*  65 */               FACTIONS.player().credits().inc(-cost, FCredits.CTYPE.MERCINARIES);
/*     */             }
/*     */           } 
/*     */ 
/*     */           
/*  70 */           if (missed == 1) {
/*  71 */             Str.TMP.clear().add(WDivMercenaries.¤¤mWBody);
/*  72 */             Str.TMP.insert(0, cc);
/*  73 */             (new MessageText(WDivMercenaries.¤¤mWTitle, (CharSequence)Str.TMP)).send();
/*  74 */           } else if (missed == 2) {
/*  75 */             (new MessageText(WDivMercenaries.¤¤mTitle, WDivMercenaries.¤¤mBody)).send();
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/*  81 */         WDivMercenary d = (WDivMercenary)WDivMercenaries.this.all.get(di);
/*     */         
/*  83 */         if (d.army() != null) {
/*  84 */           if (d.army().recruiting()) {
/*  85 */             d.menSet(CLAMP.i(d.men() + 1, 0, d.menTarget()));
/*     */           }
/*     */         }
/*     */         else {
/*     */           
/*  90 */           (STATS.POP()).age.DAYS.inc(d.cheif(), 1);
/*  91 */           if ((STATS.POP()).age.shouldDieOfOldAge(d.cheif())) {
/*  92 */             d.randomize();
/*     */           }
/*     */           
/*  95 */           if (d.disbandTime > 0.0F) {
/*  96 */             d.disbandTime = (float)(d.disbandTime - timeSinceLast);
/*     */           }
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean debug;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void randmoize() {
/* 124 */     for (int i = 0; i < this.all.max(); i++) {
/* 125 */       WDivMercenary d = (WDivMercenary)this.all.get(i);
/* 126 */       d.randomize();
/*     */     } 
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/* 131 */     for (WDivMercenary d : this.all)
/* 132 */       d.save(file); 
/* 133 */     this.updater.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/* 138 */     for (WDivMercenary d : this.all)
/* 139 */       d.load(file); 
/* 140 */     this.updater.load(file);
/*     */   }
/*     */   
/*     */   public void debug() {
/* 144 */     this.debug = true;
/* 145 */     update((TIME.secondsPerDay() * this.all.size()));
/*     */   }
/*     */ 
/*     */   
/*     */   void update(double ds) {
/* 150 */     this.updater.update(ds);
/*     */   }
/*     */   
/*     */   WDivMercenaries() {
/* 154 */     this.debug = false; D.t(this); for (int i = 0; i < this.all.max(); i++) {
/*     */       WDivMercenary d = new WDivMercenary(i); this.all.add(d);
/*     */     }  IDebugPanelWorld.add("mercs randomize", new ACTION() { public void exe() { WDivMercenaries.this.randmoize(); } });
/* 157 */   } public int max() { if (this.debug) {
/* 158 */       return size();
/*     */     }
/* 160 */     double d = FACTIONS.player().realm().all().size();
/* 161 */     for (Faction f : DIP.VASSAL().all((Faction)FACTIONS.player())) {
/* 162 */       d += f.realm().regions() / 2.0D;
/*     */     }
/* 164 */     for (Faction f : DIP.ALLY().all((Faction)FACTIONS.player())) {
/* 165 */       d += f.realm().regions() / 4.0D;
/*     */     }
/*     */     
/* 168 */     d /= 16.0D;
/* 169 */     int m = (int)(d * size());
/* 170 */     m = CLAMP.i(m, 1, size());
/* 171 */     return m; }
/*     */ 
/*     */ 
/*     */   
/*     */   public int upkeepCost(int index) {
/* 176 */     return ((WDivMercenary)this.all.get(index)).costPerMan() * ((WDivMercenary)this.all.get(index)).menTarget();
/*     */   }
/*     */   
/*     */   public int signingCost(int index) {
/* 180 */     return 4 * ((WDivMercenary)this.all.get(index)).costPerMan() * ((WDivMercenary)this.all.get(index)).menTarget();
/*     */   }
/*     */ 
/*     */   
/*     */   ADDiv get(long l) {
/* 185 */     return (ADDiv)this.all.get((int)(l & 0xFFFFL));
/*     */   }
/*     */   
/*     */   public void hire(WArmy a, WDivMercenary div) {
/* 189 */     div.reassign(a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<WDivMercenary> iterator() {
/* 196 */     return (Iterator<WDivMercenary>)this.all.iterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public WDivMercenary get(int index) {
/* 201 */     return (WDivMercenary)this.all.get(index);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(int i) {
/* 206 */     return this.all.contains(i);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean contains(WDivMercenary object) {
/* 211 */     return this.all.contains(object);
/*     */   }
/*     */ 
/*     */   
/*     */   public int size() {
/* 216 */     return this.all.size();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 221 */     return this.all.isEmpty();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\WDivMercenaries.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */