/*     */ package game.events.faction;
/*     */ 
/*     */ import game.events.EVENTS;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import view.ui.diplomacy.UIDipMess;
/*     */ import world.WORLD;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ public class EventFactionCollapse
/*     */   extends EVENTS.EventResource
/*     */ {
/*  30 */   private static final double dTime = (TIME.secondsPerDay() * 32);
/*  31 */   private double timer = dTime;
/*  32 */   private final ArrayList<Region> tmp = new ArrayList(32);
/*     */   
/*  34 */   private static CharSequence ¤¤title = "Realm Collapses";
/*  35 */   private static CharSequence ¤¤desc = "Due to internal strife, the realm of {0} has collapsed and much of its lands have been lost.";
/*  36 */   private static CharSequence ¤¤mess = "This might be a good time to expand our kingdom into these lawless lands without diplomatic penalty.";
/*     */   private int nextFaction;
/*     */   private double nextAm;
/*     */   
/*     */   static {
/*  41 */     D.ts(EventFactionCollapse.class);
/*     */   }
/*     */   
/*     */   EventFactionCollapse() {
/*  45 */     super("FACTION_COLLAPSE");
/*  46 */     clear();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {
/*  52 */     this.timer -= ds;
/*  53 */     if (this.timer < 0.0D) {
/*     */       
/*  55 */       Faction f = FACTIONS.getByIndex(this.nextFaction);
/*     */       
/*  57 */       if (f.isActive() && f instanceof FactionNPC && DIP.WAR().all(f).size() == 0) {
/*  58 */         FactionNPC ff = (FactionNPC)f;
/*  59 */         if (!ff.sanctified)
/*  60 */           shatter((FactionNPC)f); 
/*     */       } 
/*  62 */       clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void shatter(FactionNPC f) {
/*  70 */     if (f.realm().regions() <= 1)
/*     */       return; 
/*  72 */     int si = 1;
/*  73 */     if (f.realm().regions() > 2)
/*  74 */       si = 1 + RND.rInt(f.realm().regions() - 1); 
/*  75 */     Region start = f.realm().region(si);
/*     */     
/*  77 */     int am = (int)(f.realm().regions() * this.nextAm);
/*  78 */     am = CLAMP.i(am, 1, 32);
/*     */     
/*  80 */     this.tmp.clear();
/*  81 */     for (WRegFinder.RegDist d : (WORLD.PATH()).regFinder.all(start, WRegFinder.Treaty.FACTION, WRegSel.DUMMY())) {
/*  82 */       if (d.reg.faction() == f && d.reg != f.capitolRegion()) {
/*  83 */         this.tmp.add(d.reg);
/*  84 */         am--;
/*  85 */         if (am <= 0) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     if (this.tmp.size() > 0) {
/*  92 */       Str.TMP.clear().add(¤¤desc).insert(0, (CharSequence)f.name);
/*  93 */       WORLD.LOG().log((Faction)f, null, (UI.icons()).s.degrade, (CharSequence)Str.TMP, f.cx(), f.cy());
/*  94 */       if (RD.DIST().factionHasRegionBorderingPlayer((Faction)f)) {
/*  95 */         (new UIDipMess(¤¤title, (CharSequence)Str.TMP.clear().add(¤¤desc).insert(0, (CharSequence)f.name), ¤¤mess, f)).send();
/*     */       }
/*  97 */       for (Region reg : this.tmp) {
/*  98 */         if (reg.faction() != f)
/*     */           continue; 
/* 100 */         RD.setFaction(reg, null, true);
/* 101 */         for (WArmy a : (WORLD.ENTITIES()).armies.fill(reg)) {
/* 102 */           if (a.faction() == f) {
/* 103 */             a.disband();
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 114 */     file.d(this.timer);
/* 115 */     file.i(this.nextFaction);
/* 116 */     file.d(this.nextAm);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 121 */     this.timer = file.d();
/* 122 */     this.nextFaction = file.i();
/* 123 */     this.nextAm = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 128 */     this.timer = RND.rFloat() * dTime;
/* 129 */     this.nextFaction = RND.rInt(FACTIONS.MAX());
/* 130 */     this.nextAm = RND.rFloat();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\EventFactionCollapse.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */