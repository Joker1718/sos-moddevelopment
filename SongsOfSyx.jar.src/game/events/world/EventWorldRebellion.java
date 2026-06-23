/*     */ package game.events.world;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.events.EVENTS;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.D;
/*     */ import view.ui.message.MessageText;
/*     */ import view.world.panel.IDebugPanelWorld;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ import world.army.WDivRegional;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ public class EventWorldRebellion
/*     */   extends EVENTS.EventResource
/*     */ {
/*  37 */   private static CharSequence ¤¤Rebellion = "¤Rebellion!";
/*  38 */   private static CharSequence ¤¤Warning = "¤Rebellion Imminent!";
/*  39 */   private static CharSequence ¤¤WarningD = "¤The region of {0} has very low public order, and could rebel any day now. A temporary fix would be to station troops there, deterring the troublemakers, but in the long run, we should look into fixing these problems permanently.";
/*  40 */   private static CharSequence ¤¤RebellionD = "¤The region of {0} has had enough of your mistreatment and have declared independency from your tyrannical rule.";
/*  41 */   private static CharSequence ¤¤RebellionArmy = "¤In fact they hate you so much that they have raised an army against you. You better deal with this problem before it spreads.";
/*     */ 
/*     */   
/*  44 */   private double timer = 0.0D;
/*  45 */   private int ri = 0;
/*  46 */   private final Bitmap1D warning = new Bitmap1D(1023, false);
/*     */   
/*     */   static {
/*  49 */     D.ts(EventWorldRebellion.class);
/*     */   }
/*     */   
/*     */   public EventWorldRebellion() {
/*  53 */     super("REBELLION");
/*  54 */     IDebugPanelWorld.add("Rebellion", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  58 */             int ri = RND.rInt(FACTIONS.player().realm().all().size());
/*  59 */             if (ri >= 1) {
/*  60 */               EventWorldRebellion.this.rebel(FACTIONS.player().realm().region(ri));
/*     */             }
/*     */           }
/*     */         });
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
/*     */   protected void save(FilePutter file) {
/*  80 */     file.d(this.timer);
/*  81 */     file.i(this.ri);
/*  82 */     this.warning.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  87 */     this.timer = file.d();
/*  88 */     this.ri = file.i();
/*  89 */     this.warning.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/*  94 */     this.ri = 0;
/*  95 */     this.timer = 0.0D;
/*  96 */     this.warning.setAll(false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/* 102 */     if (FACTIONS.player().realm().regions() == 0)
/*     */       return; 
/* 104 */     int t = (int)this.timer;
/* 105 */     this.timer += ds;
/*     */ 
/*     */ 
/*     */     
/* 109 */     if (this.timer > TIME.secondsPerDay()) {
/* 110 */       this.timer -= TIME.secondsPerDay();
/* 111 */       this.ri++;
/* 112 */       if (this.ri >= FACTIONS.player().realm().regions())
/* 113 */         this.ri = 0; 
/* 114 */       Region reg = FACTIONS.player().realm().region(this.ri);
/* 115 */       if (reg.capitol()) {
/*     */         return;
/*     */       }
/* 118 */       if ((RD.RACES()).loyaltyAll.getD(reg) <= 0.0D) {
/* 119 */         if (!this.warning.get(this.ri)) {
/* 120 */           this.warning.set(this.ri, true);
/* 121 */           (new MessageText(¤¤Warning)).paragraph((CharSequence)GText.TMP.clear().add(¤¤WarningD).insert(0, (CharSequence)reg.info.name())).send();
/*     */         } else {
/* 123 */           rebel(reg);
/*     */         }
/*     */       
/* 126 */       } else if ((RD.RACES()).loyaltyAll.getD(reg) > 0.5D) {
/* 127 */         this.warning.set(this.ri, false);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rebel(Region reg) {
/* 135 */     if (reg.capitol()) {
/*     */       return;
/*     */     }
/*     */     
/* 139 */     RD.setFaction(reg, null, true);
/*     */     
/* 141 */     int men = men(reg);
/* 142 */     WArmy a = null;
/* 143 */     if ((WORLD.ENTITIES()).armies.canCreate() && men > 10 && RND.rBoolean()) {
/* 144 */       a = army(reg, men);
/*     */     }
/*     */     
/* 147 */     MessageText m = new MessageText(¤¤Rebellion);
/* 148 */     m.paragraph((CharSequence)Str.TMP.clear().add(¤¤RebellionD).insert(0, (CharSequence)reg.info.name()));
/*     */     
/* 150 */     if (a != null) {
/* 151 */       m.paragraph(¤¤RebellionArmy);
/*     */     }
/* 153 */     m.send();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int men(Region reg) {
/* 159 */     int men = (RD.MILITARY()).garrison.get(reg);
/*     */     
/* 161 */     for (WArmy a2 : FACTIONS.player().armies().all()) {
/* 162 */       if (a2.region() == reg) {
/* 163 */         men += AD.men(null).get(a2); continue;
/* 164 */       }  if (a2.region() != null && a2.region().faction() == FACTIONS.player()) {
/* 165 */         men = (int)(men + 0.25D * AD.men(null).get(a2)); continue;
/*     */       } 
/* 167 */       men = (int)(men + 0.125D * AD.men(null).get(a2));
/*     */     } 
/*     */     
/* 170 */     men = (int)(men * (1.0D + RND.rExpo()));
/*     */     
/* 172 */     if (men < 30) {
/* 173 */       men = 30 + RND.rInt(20);
/*     */     }
/*     */ 
/*     */     
/* 177 */     men = CLAMP.i(men, 0, (Config.battle()).MEN_PER_ARMY);
/*     */     
/* 179 */     return men;
/*     */   }
/*     */   
/*     */   public WArmy army(Region reg, int men) {
/* 183 */     COORDINATE c = WORLD.PATH().rnd(reg);
/*     */     
/* 185 */     WArmy a = (WORLD.ENTITIES()).armies.create(c.x(), c.y(), null);
/* 186 */     if (a == null) {
/* 187 */       GAME.Notify("" + c.x() + " " + c.x());
/* 188 */       return null;
/*     */     } 
/*     */     
/* 191 */     double raceTot = 0.0D;
/* 192 */     Race biggest = (Race)RACES.all().get(0);
/* 193 */     int b = 0;
/* 194 */     for (RDRace r : (RD.RACES()).all) {
/* 195 */       raceTot += r.pop.get(reg);
/* 196 */       if (r.pop.get(reg) > b) {
/* 197 */         biggest = r.race;
/*     */       }
/*     */     } 
/*     */     
/* 201 */     double menLeft = 0.0D;
/*     */     
/* 203 */     for (RDRace r : (RD.RACES()).all) {
/*     */       
/* 205 */       menLeft += (men * r.pop.get(reg)) / raceTot;
/*     */       
/* 207 */       while (menLeft > 2.0D && a.divs().canAdd()) {
/*     */ 
/*     */         
/* 210 */         int am = CLAMP.i((int)menLeft, 0, (Config.battle()).MEN_PER_DIVISION);
/*     */ 
/*     */         
/* 213 */         WDivRegional d = AD.regional().create(r.race, am / (Config.battle()).MEN_PER_DIVISION, a);
/* 214 */         d.randomize(RND.rExpo(), RND.rExpo());
/* 215 */         d.menSet(d.menTarget());
/* 216 */         menLeft -= am;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 221 */     a.name.clear().add((CharSequence)biggest.info.armyNames.rnd());
/*     */     
/* 223 */     for (ADSupply s : (AD.supplies()).all) {
/* 224 */       s.current().set(a, s.targetAmount(a));
/*     */     }
/*     */     
/* 227 */     return a;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\world\EventWorldRebellion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */