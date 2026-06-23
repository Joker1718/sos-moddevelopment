/*     */ package game.raiding;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HTYPES;
/*     */ import java.io.Serializable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.training.barracks.ROOM_BARRACKS;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Raider
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public final Induvidual indu;
/*     */   public final String name;
/*     */   public RaiderArmy army;
/*     */   public int raids;
/*     */   public int bounty;
/*     */   public boolean defeated = false;
/*     */   public double worth;
/*     */   boolean hasAttacked = false;
/*     */   public final RaiderText text;
/*     */   public double secondDefeated;
/*     */   
/*     */   Raider(double wealth, double power, double quality) {
/*  39 */     double ri = 0.0D;
/*  40 */     for (Race r : RACES.all()) {
/*  41 */       ri += r.physics.raiding;
/*     */     }
/*  43 */     ri *= RND.rFloat();
/*  44 */     Race rr = (Race)RACES.playable().rnd();
/*  45 */     for (Race r : RACES.all()) {
/*  46 */       ri -= r.physics.raiding;
/*  47 */       if (ri <= 0.0D) {
/*  48 */         rr = r;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*  53 */     this.indu = new Induvidual(HTYPES.SOLDIER(), rr);
/*  54 */     Str.TMP.clear().add((this.indu.race()).info.raiderNames[RND.rInt((this.indu.race()).info.raiderNames.length)]);
/*  55 */     Str.TMP.insert(0, (STATS.APPEARANCE()).nameFirst.name(this.indu));
/*  56 */     this.name = String.valueOf(Str.TMP);
/*  57 */     adjust(wealth, power, quality);
/*  58 */     this.text = new RaiderText();
/*     */   }
/*     */   
/*     */   public Raider(Race race, double power) {
/*  62 */     this.indu = new Induvidual(HTYPES.SOLDIER(), race);
/*  63 */     Str.TMP.clear().add((this.indu.race()).info.raiderNames[RND.rInt((this.indu.race()).info.raiderNames.length)]);
/*  64 */     Str.TMP.insert(0, (STATS.APPEARANCE()).nameFirst.name(this.indu));
/*  65 */     this.name = String.valueOf(Str.TMP);
/*  66 */     adjust(0.0D, power, RND.rFloat());
/*  67 */     this.text = new RaiderText();
/*     */   }
/*     */   
/*     */   public void adjust(double wealth, double power, double quality) {
/*  71 */     this.worth = wealth;
/*  72 */     this.army = new RaiderArmy(this.indu.race(), power, quality);
/*  73 */     this.bounty = (int)wealth;
/*     */   }
/*     */   
/*     */   public void hover(GUI_BOX text) {
/*  77 */     GBox b = (GBox)text;
/*  78 */     b.title(this.name);
/*     */     
/*  80 */     b.text(Dic.¤¤Soldiers);
/*  81 */     b.tab(6);
/*  82 */     b.add((SPRITE)GFORMAT.i(b.text(), this.army.men));
/*  83 */     b.NL();
/*     */     
/*  85 */     b.text(Dic.¤¤Power);
/*  86 */     b.tab(6);
/*  87 */     b.add((SPRITE)GFORMAT.i(b.text(), this.army.power));
/*  88 */     b.NL();
/*     */     
/*  90 */     b.text(Dic.¤¤Currs);
/*  91 */     b.tab(6);
/*  92 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)this.worth));
/*  93 */     b.NL();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasInterrest() {
/*  98 */     if (!((ROOM_BARRACKS)(SETT.ROOMS()).BARRACKS.get(0)).reqs.passes(FACTIONS.player()))
/*  99 */       return false; 
/* 100 */     if ((STATS.POP()).POP.data(null).get(null) < 200)
/* 101 */       return false; 
/* 102 */     return ((GAME.raiders()).util.ransomCurrent() > this.worth);
/*     */   }
/*     */   
/*     */   public boolean isScared() {
/* 106 */     return !(this.army.power >= (GAME.raiders()).util.weakestRegionPow() && this.army.power >= (GAME.raiders()).util.playerPow());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\Raider.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */