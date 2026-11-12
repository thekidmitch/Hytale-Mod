# Architecture

## Overview

AICompanion is an experimental Java plugin for Hytale that connects an in-game NPC to a locally hosted AI service.

The intended architecture separates game integration, AI conversation, NPC state, and persistent data.

## Main Components

### Hytale Plugin

`AICompanionPlugin.java` contains the primary plugin implementation.

Its responsibilities include game-side integration, conversation handling, NPC-related behavior, and communication with the AI service.

### Asset Pack Loader

`AssetPackLoader.java` supports loading the project's custom asset-pack content.

### NPC Role Data

`datapack/Server/NPC/Roles/AICompanion_Erik.json` defines the custom Erik NPC role.

### Local AI

The plugin communicates with Ollama through its local HTTP API. This allows development without requiring a paid hosted AI API.

### Persistent State

The project has used separate data files for information such as:
- Conversation history.
- Player memories.
- Erik's journal.
- Goals.
- Preferences.
- Relationship information.

The exact storage implementation may evolve during development.

## Design Principles

1. Keep game integration separate from AI-generated responses where practical.
2. Preserve important NPC information between sessions.
3. Allow NPC personalities and relationships to evolve.
4. Keep the AI backend locally configurable.
5. Validate behavior in an actual Hytale test world.

## Current Limitations

NPC movement, reliable spawn lifecycle management, and autonomous settlement simulation are still under development.
