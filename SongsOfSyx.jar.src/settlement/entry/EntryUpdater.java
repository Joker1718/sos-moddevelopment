/*     */ package settlement.entry;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import init.sprite.UI.UI;
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.ui.message.MessageSection;
/*     */ import view.ui.message.MessageText;
/*     */ import world.WORLD;
/*     */ import world.entity.WEntity;
/*     */ import world.entity.army.WArmy;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ final class EntryUpdater implements SAVABLE {
/*  28 */   private static CharSequence ¤¤open = "Capital Open!";
/*  29 */   private static CharSequence ¤¤openD = "Your capital is now open for immigrants and trade.";
/*  30 */   private static CharSequence ¤¤closed = "Capital Closed!";
/*  31 */   private static CharSequence ¤¤closedD = "Your throne can not be reached from the outside world. As a consequence, no immigration or trade can occur. Clear a path from the throne to a country road as soon as possible.";
/*     */ 
/*     */   
/*  34 */   private static CharSequence ¤¤mTitle = "City Isolated!";
/*  35 */   private static CharSequence ¤¤mDesc = "One or several of our city's entry points have been blocked off, and as a result, outsiders will have a problem reaching us. This will have many negative consequences and should be fixed as quickly as possible.";
/*     */   
/*     */   static {
/*  38 */     D.ts(EntryUpdater.class);
/*     */   }
/*     */   
/*  41 */   private double checkTimer = 0.0D;
/*     */   private boolean isClosed = false;
/*     */   private boolean besieged;
/*  44 */   private double besigeTime = 0.0D;
/*     */ 
/*     */   
/*     */   public void update(double ds, EntryPoints points) {
/*  48 */     if (VIEW.b().isActive()) {
/*     */       return;
/*     */     }
/*  51 */     if (FACTIONS.player().capitolRegion() == null) {
/*     */       return;
/*     */     }
/*  54 */     int oldReach = points.reachable().size();
/*     */     
/*  56 */     points.update();
/*     */ 
/*     */ 
/*     */     
/*  60 */     if (oldReach > points.reachable().size());
/*     */ 
/*     */ 
/*     */     
/*  64 */     if (!SETT.INVADOR().invading()) {
/*     */ 
/*     */       
/*  67 */       this.checkTimer += ds;
/*  68 */       if (this.checkTimer > 5.0D) {
/*  69 */         this.checkTimer -= 5.0D;
/*  70 */         Region c = FACTIONS.player().capitolRegion();
/*     */         
/*  72 */         this.besieged = false;
/*     */         
/*  74 */         if (SETT.INVADOR().invading()) {
/*  75 */           this.besieged = true;
/*     */         } else {
/*  77 */           for (WEntity e : WORLD.ENTITIES().fillTiles(c.cx() - 3, c.cx() + 3, c.cy() - 3, c.cy() + 3)) {
/*  78 */             if (e instanceof WArmy) {
/*  79 */               WArmy a = (WArmy)e;
/*  80 */               if (DIP.WAR().is(a.faction(), (Faction)FACTIONS.player()) && a.besieging(FACTIONS.player().capitolRegion())) {
/*  81 */                 this.besieged = true;
/*     */ 
/*     */ 
/*     */                 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/*  93 */         if (this.besieged) {
/*  94 */           this.isClosed = true;
/*  95 */         } else if (this.isClosed && points.hasAny()) {
/*  96 */           this.isClosed = false;
/*  97 */           if (!VIEW.b().isActive())
/*  98 */             (new MessageText(¤¤open, ¤¤openD)).send(); 
/*  99 */         } else if (!this.isClosed && !points.hasAny()) {
/* 100 */           if (!VIEW.b().isActive())
/* 101 */             (new MessageText(¤¤closed, ¤¤closedD)).send(); 
/* 102 */           this.isClosed = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     if (this.besieged) {
/* 113 */       this.besigeTime += ds;
/*     */     } else {
/* 115 */       this.besigeTime = 0.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 123 */     file.bool(this.isClosed);
/* 124 */     file.d(this.checkTimer);
/* 125 */     file.bool(this.besieged);
/* 126 */     file.d(this.besigeTime);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 131 */     this.isClosed = file.bool();
/* 132 */     this.checkTimer = file.d();
/* 133 */     this.besieged = file.bool();
/* 134 */     this.besigeTime = file.d();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 139 */     this.isClosed = false;
/* 140 */     this.checkTimer = 0.0D;
/* 141 */     this.besieged = false;
/* 142 */     this.besigeTime = 0.0D;
/*     */   }
/*     */   
/*     */   public boolean isClosed() {
/* 146 */     return this.isClosed;
/*     */   }
/*     */   
/*     */   public boolean beseiged() {
/* 150 */     return this.besieged;
/*     */   }
/*     */   
/*     */   public double besigeTime() {
/* 154 */     return this.besigeTime;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Mess
/*     */     extends MessageSection
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     ArrayCooShort coos;
/*     */     
/*     */     public Mess(EntryPoints po) {
/* 166 */       super(EntryUpdater.¤¤mTitle);
/* 167 */       this.coos = new ArrayCooShort(po.active().size() - po.reachable().size());
/* 168 */       for (EntryPoints.EntryPoint p : po.active()) {
/* 169 */         if (!p.reachable()) {
/* 170 */           this.coos.get().set(p.coo());
/* 171 */           this.coos.inc();
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void make(GuiSection section) {
/* 178 */       paragraph(EntryUpdater.¤¤mDesc);
/*     */       
/* 180 */       this.coos.set(0);
/*     */       
/*     */       while (true) {
/* 183 */         section.addRelBody(8, DIR.S, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(UI.icons()).m.crossair)
/*     */             {
/* 185 */               final int tx = EntryUpdater.Mess.this.coos.get().x();
/* 186 */               final int ty = EntryUpdater.Mess.this.coos.get().y();
/*     */ 
/*     */               
/*     */               protected void clickA() {
/* 190 */                 VIEW.s().activate();
/* 191 */                 VIEW.s().getWindow().centerAtTile(this.tx, this.ty);
/*     */               }
/* 194 */             }).pad(20, 2));
/*     */         
/* 196 */         if (!this.coos.hasNext())
/*     */           return; 
/* 198 */         this.coos.next();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entry\EntryUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */